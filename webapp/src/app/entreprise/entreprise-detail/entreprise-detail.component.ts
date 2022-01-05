import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EntrepriseService } from '../../shared/service/entreprise.service';
import { Entreprise } from '../../model/entreprise.model';
import { Stage } from '../../model/stage.model';

@Component({
    selector: 'app-entreprise-detail',
    templateUrl: './entreprise-detail.component.html',
    styleUrls: ['./entreprise-detail.component.css']
})
export class EntrepriseDetailComponent implements OnInit {

    public entreprise?: Entreprise;

    constructor(
        private readonly activatedRoute: ActivatedRoute,
        private readonly entrepriseService : EntrepriseService,
        private readonly router: Router
    ) { }

    ngOnInit(): void {
        this.activatedRoute.paramMap.subscribe(async p => {
            const id = p.get('idEntreprise');
            if (id) {
                this.entrepriseService.findEntrepriseById(id)
                    .then(entreprise => this.entreprise = entreprise)
                    .catch(() => this.router.navigate(['/entreprise']));
            }
        });
    }

    get stages(): Stage[] {
        return this.entreprise?.stages ?? [];
    }

    get specialitesLibelle(): string {
        return this.entreprise?.specialites?.map(specialite => specialite.libelle).join(' / ') ?? 'Aucune';
    }

}

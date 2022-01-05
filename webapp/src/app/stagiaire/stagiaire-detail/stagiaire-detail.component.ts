import { Component, OnInit } from '@angular/core';
import { EtudiantService } from '../../shared/service/etudiant.service';
import { Etudiant } from '../../model/etudiant.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-stagiaire-detail',
  templateUrl: './stagiaire-detail.component.html',
  styleUrls: ['./stagiaire-detail.component.css']
})
export class StagiaireDetailComponent implements OnInit {

    public stagiaire?: Etudiant;

    constructor(
        private readonly stagiaireservice: EtudiantService,
        private readonly activatedRoute: ActivatedRoute,
        private readonly router: Router
    ) { }

    ngOnInit(): void {
        this.activatedRoute.paramMap.subscribe(async p => {
            const id = p.get('idStagiaire');
            if (id) {
                await this.stagiaireservice.findEtudiantById(id)
                    .then(stagiaire => this.stagiaire = stagiaire)
                    .catch(() => this.router.navigate(['/stagiaire']));
            }
        });
    }

}

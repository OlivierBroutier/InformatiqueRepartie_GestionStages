import { Component, OnInit } from '@angular/core';
import {Entreprise} from "../model/entreprise.model";
import {EntrepriseService} from "../shared/service/entreprise.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-entreprise',
    templateUrl: './entreprise.component.html',
    styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent implements OnInit {

    public entreprises : Entreprise[] = [];
    public nom: string = '';
    public entreprises_find : Entreprise[] = [];

    constructor(
        private entreprise_service : EntrepriseService,
        private router: Router
    ) { }

    async ngOnInit(): Promise<void> {
        this.entreprises = await this.entreprise_service.findAllEntreprise();
        this.entreprises_find = this.entreprises;
    }

    public rechercher() {
        this.entreprises_find = [];
        for(let entreprise of this.entreprises) {
            if (entreprise.raisonSociale?.toLowerCase()?.includes(this.nom.toLowerCase())
                || entreprise.nomResp?.toLowerCase()?.includes(this.nom.toLowerCase())) {
                this.entreprises_find.push(entreprise);
            }
        }
    }

    public editEntreprise(entreprise: Entreprise): void {
        this.router.navigate(['/entreprise/ajout'], { state: { entreprise } });
    }

    public inscription(entreprise: Entreprise): void {
        this.router.navigate(['/inscription'], { state: { entreprise } });
    }
}

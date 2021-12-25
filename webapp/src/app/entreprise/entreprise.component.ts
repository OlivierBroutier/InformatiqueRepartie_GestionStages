import { Component, OnInit } from '@angular/core';
import {Entreprise} from "../model/entreprise.model";
import {EntrepriseService} from "../shared/service/entreprise.service";
import {Router} from "@angular/router";
import {SuccessService} from "../shared/service/success.service";

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
        private router: Router,
        private success_service : SuccessService
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

    public removeEntreprise(entreprise: Entreprise): void {
        if(entreprise.id) {
            this.entreprise_service.deleteEntreprise(String(entreprise.id));
            this.success_service.createSuccessAlert('Succès', 'L\'entreprise a bien été supprimée');
            this.entreprises = [...this.entreprises].filter(e => e.id !== entreprise.id);
            this.entreprises_find = [...this.entreprises_find].filter(e => e.id !== entreprise.id);
        }


    }
}

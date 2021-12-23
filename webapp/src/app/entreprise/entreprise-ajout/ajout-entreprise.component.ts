import { Component, OnInit } from '@angular/core';
import {Specialite} from "../../model/specialite.model";
import {SpecialiteService} from "../../shared/service/specialite.service";
import {Entreprise} from "../../model/entreprise.model";
import {EntrepriseService} from "../../shared/service/entreprise.service";

@Component({
    selector: 'app-ajout-entreprise',
    templateUrl: './ajout-entreprise.component.html',
    styleUrls: ['./ajout-entreprise.component.css']
})
export class AjoutEntrepriseComponent implements OnInit {
    public specialites : Specialite[] = [];
    public entreprise : Entreprise = {};
    public entreprise_resultat? : Entreprise;

    constructor(private specialite_service : SpecialiteService, private entreprise_service : EntrepriseService) { }

    async ngOnInit(): Promise<void> {
        this.specialites = await this.specialite_service.findAllSpecialite();
        this.entreprise = window.history.state.entreprise ?? { };
    }

    public get isEditing(): boolean {
        return !!this.entreprise.id;
    }

    public async ajout(): Promise<void> {
        this.entreprise_resultat = await this.entreprise_service.ajoutEntreprise(this.entreprise);
    }

    public async edit(): Promise<void> {
        this.entreprise_resultat = await this.entreprise_service.updateEntreprise(this.entreprise);
    }
}

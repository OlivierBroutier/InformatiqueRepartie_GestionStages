import { Component, OnInit } from '@angular/core';
import { Specialite } from '../../model/specialite.model';
import { SpecialiteService } from '../../shared/service/specialite.service';
import { Entreprise } from '../../model/entreprise.model';
import { EntrepriseService } from '../../shared/service/entreprise.service';
import { SuccessService } from '../../shared/service/success.service';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
    selector: 'app-ajout-entreprise',
    templateUrl: './ajout-entreprise.component.html',
    styleUrls: ['./ajout-entreprise.component.css']
})
export class AjoutEntrepriseComponent implements OnInit {

    public specialites : Specialite[] = [];
    public entreprise : Entreprise = {};

    constructor(
        private readonly specialiteService: SpecialiteService,
        private readonly entrepriseService: EntrepriseService,
        private readonly successService: SuccessService,
        private readonly location: Location,
        private router: Router
    ) { }

    async ngOnInit(): Promise<void> {
        this.specialites = await this.specialiteService.findAllSpecialite();
        this.entreprise = window.history.state.entreprise ?? { };
    }

    public get isEditing(): boolean {
        return !!this.entreprise.id;
    }

    public async ajout(): Promise<void> {
        await this.entrepriseService.ajoutEntreprise(this.entreprise);
        this.successService.createSuccessAlert('Succès', 'L\'entreprise a bien été créée');
        this.router.navigate(['/entreprise']);
    }

    public async edit(): Promise<void> {
        this.entreprise = await this.entrepriseService.updateEntreprise(this.entreprise);
        this.successService.createSuccessAlert('Succès', 'L\'entreprise a bien été modifiée');
    }
}

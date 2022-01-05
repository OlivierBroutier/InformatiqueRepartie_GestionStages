import { Component, OnInit } from '@angular/core';
import { EntrepriseService } from '../shared/service/entreprise.service';
import { Entreprise } from '../model/entreprise.model';
import { Etudiant } from '../model/etudiant.model';
import { EtudiantService } from '../shared/service/etudiant.service';
import { Professeur } from '../model/professeur.model';
import { ProfesseurService } from '../shared/service/professeur.service';
import { Stage } from '../model/stage.model';
import { AuthentificationService } from '../shared/service/authentification.service';
import { StageService } from '../shared/service/stage.service';
import { SuccessService } from '../shared/service/success.service';
import { Router } from '@angular/router';
import { Mission } from '../model/mission.model';

@Component({
    selector: 'app-inscription',
    templateUrl: './inscription.component.html',
    styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

    public entreprises: Entreprise[] = [];
    public etudiants: Etudiant[] = [];
    public professeurs: Professeur[] = [];

    public stage: Stage = { typeStage: 'aucun' };
    public stage_resultat?: Stage;

    constructor(
        private readonly entrepriseService : EntrepriseService,
        private readonly etudiantService : EtudiantService,
        private readonly professeurService : ProfesseurService,
        private readonly authentificationService: AuthentificationService,
        private readonly stageService : StageService,
        private readonly successService: SuccessService,
        private readonly router: Router
    ) { }

    async ngOnInit(): Promise<void> {
        this.entreprises = await this.entrepriseService.findAllEntreprise();
        this.etudiants = await this.etudiantService.findAllEtudiant();
        this.professeurs = await this.professeurService.findAllProfesseur();

        if (this.authentificationService.userIsEtudiant) {
            this.stage.etudiant = this.authentificationService.etudiant;
        }

        if (this.authentificationService.userIsProfesseur) {
            this.stage.professeur = this.authentificationService.professeur;
        }

        if (window.history.state.stagiaire) {
            this.stage.etudiant = window.history.state.stagiaire;
        }

        if (window.history.state.entreprise) {
            this.stage.entreprise = window.history.state.entreprise;
        }
    }

    public get missions(): Mission[] {
        return this.stage.missions ?? [];
    }

    public set missions(missions: Mission[]) {
        this.stage.missions = missions;
    }

    public compare(a: any, b: any): boolean {
        return a && b ? a.id === b.id : a === b
    }

    public async valider(): Promise<void> {
        this.stage_resultat = await this.stageService.ajoutStage(this.stage);
        this.successService.createSuccessAlert('Succès', 'Le stage a bien été créé');
        this.router.navigate(['/stage']);

    }


}

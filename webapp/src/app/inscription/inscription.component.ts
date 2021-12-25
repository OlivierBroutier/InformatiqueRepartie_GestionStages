import { Component, OnInit } from '@angular/core';
import {EntrepriseService} from "../shared/service/entreprise.service";
import {Entreprise} from "../model/entreprise.model";
import {Etudiant} from "../model/etudiant.model";
import {EtudiantService} from "../shared/service/etudiant.service";
import {Professeur} from "../model/professeur.model";
import {ProfesseurService} from "../shared/service/professeur.service";
import {Stage} from "../model/stage.model";
import {AuthentificationService} from "../shared/authentification.service";
import {StageService} from "../shared/service/stage.service";

@Component({
    selector: 'app-inscription',
    templateUrl: './inscription.component.html',
    styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

    public entreprises: Entreprise[] = [];
    public etudiants: Etudiant[] = [];
    public professeurs: Professeur[] = [];
    public stage : Stage = {};
    public type_stage: undefined ;
    public date_debut: string= '';
    public date_fin : string= '';
    public stage_resultat? : Stage;

    constructor(
        private entrepriseService : EntrepriseService,
        private etudiantService : EtudiantService,
        private professeurService : ProfesseurService,
        private authentificationService: AuthentificationService,
        private stageService : StageService
    ) { }

    async ngOnInit(): Promise<void> {
        this.entreprises = await this.entrepriseService.findAllEntreprise();
        this.etudiants = await this.etudiantService.findAllEtudiant();
        this.professeurs = await this.professeurService.findAllProfesseur();
        this.stage.professeur = this.authentificationService.professeur;
        this.stage.entreprise = window.history.state.entreprise;
            }

    public compare(a: any, b: any): boolean {
        return a && b ? a.id === b.id : a === b
    }

    public async valider(): Promise<void> {
        this.stage_resultat = await this.stageService.ajoutStage(this.stage);

    }


}
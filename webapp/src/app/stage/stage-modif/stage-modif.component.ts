import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Stage} from "../../model/stage.model";
import {StageService} from "../../shared/service/stage.service";
import {Entreprise} from "../../model/entreprise.model";
import {EntrepriseService} from "../../shared/service/entreprise.service";
import {Etudiant} from "../../model/etudiant.model";
import {EtudiantService} from "../../shared/service/etudiant.service";
import {Professeur} from "../../model/professeur.model";
import {ProfesseurService} from "../../shared/service/professeur.service";
import {SuccessService} from "../../shared/service/success.service";

@Component({
  selector: 'app-stage-modif',
  templateUrl: './stage-modif.component.html',
  styleUrls: ['./stage-modif.component.css']
})
export class StageModifComponent implements OnInit {

    public stage : Stage = {};
    public entreprises: Entreprise[] = [];
    public etudiants : Etudiant[] = [];
    public professeurs : Professeur[] = [];
    public stage_resultat : Stage = {};

    constructor(private activatedRoute : ActivatedRoute, private stageService : StageService, private entrepriseService : EntrepriseService,
                private etudiantService : EtudiantService, private professeurService : ProfesseurService,
                private readonly successService: SuccessService,
                private router: Router) { }

    async ngOnInit(): Promise<void> {
        this.activatedRoute.paramMap.subscribe(async p => {
            const id = p.get('idStage');
            if (id) {
                this.stage = await this.stageService.findStageById(id);
            }
        });
        this.entreprises = await this.entrepriseService.findAllEntreprise();
        this.etudiants = await this.etudiantService.findAllEtudiant();
        this.professeurs = await this.professeurService.findAllProfesseur();
    }

    public compare(a: any, b: any): boolean {
        return a && b ? a.id === b.id : a === b
    }

    public async valider(): Promise<void> {
        this.stage_resultat = await this.stageService.modifStage(this.stage);
        this.successService.createSuccessAlert('Succès', 'Le stage a bien été modifié');
        this.router.navigate(['/stage']);

    }
}

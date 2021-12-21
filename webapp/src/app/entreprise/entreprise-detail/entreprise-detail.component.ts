import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {EntrepriseService} from "../../shared/service/entreprise.service";
import {Entreprise} from "../../model/entreprise.model";
import {Stage} from "../../model/stage.model";
import {StageService} from "../../shared/service/stage.service";

@Component({
    selector: 'app-entreprise-detail',
    templateUrl: './entreprise-detail.component.html',
    styleUrls: ['./entreprise-detail.component.css']
})
export class EntrepriseDetailComponent implements OnInit {

    public entreprise?: Entreprise;
    public stages? : Stage[] = [];

    constructor(
        private activatedRoute: ActivatedRoute, private entrepriseService : EntrepriseService, private stageService : StageService
    ) { }

    ngOnInit(): void {
        this.activatedRoute.paramMap.subscribe(async p => {
            const id = p.get('idEntreprise');
            if (id) {
                this.entreprise = await this.entrepriseService.findEntrepriseById(id);
                this.stages = await this.stageService.findStageByEntrepriseId(id);
            }
        });
    }

}

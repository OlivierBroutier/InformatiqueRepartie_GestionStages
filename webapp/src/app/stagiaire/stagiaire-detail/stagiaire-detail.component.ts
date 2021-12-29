import { Component, OnInit } from '@angular/core';
import {EtudiantService} from "../../shared/service/etudiant.service";
import {Etudiant} from "../../model/etudiant.model";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-stagiaire-detail',
  templateUrl: './stagiaire-detail.component.html',
  styleUrls: ['./stagiaire-detail.component.css']
})
export class StagiaireDetailComponent implements OnInit {

    public stagiaire?: Etudiant;

    constructor(private stagiaireservice : EtudiantService,private activatedRoute: ActivatedRoute) { }

    ngOnInit(): void {
        this.activatedRoute.paramMap.subscribe(async p => {
            const id = p.get('idStagiaire');
            if (id) {
                this.stagiaire = await this.stagiaireservice.findEtudiantById(id);
            }
        });
    }

}

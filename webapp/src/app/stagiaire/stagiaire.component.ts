import { Component, OnInit } from '@angular/core';
import {Etudiant} from "../model/etudiant.model";
import {EtudiantService} from "../shared/service/etudiant.service";
import {Router} from "@angular/router";
import {SuccessService} from "../shared/service/success.service";
import {Stage} from "../model/stage.model";
import {StageService} from "../shared/service/stage.service";

@Component({
  selector: 'app-stagiaire',
  templateUrl: './stagiaire.component.html',
  styleUrls: ['./stagiaire.component.css']
})
export class StagiaireComponent implements OnInit {
    public stagiaires : Etudiant[] = [];
    public nom: string = '';
    public stagiaires_find : Etudiant[] = [];
    public stages : Stage[] = [];

  constructor(private stagiaire_service : EtudiantService, private router : Router, private success_service : SuccessService, private stage_service : StageService) { }

  async ngOnInit(): Promise<void> {
      this.stagiaires = await this.stagiaire_service.findAllEtudiant();
      this.stagiaires_find = this.stagiaires;
  }

}



    /*public rechercher() {
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
}*/


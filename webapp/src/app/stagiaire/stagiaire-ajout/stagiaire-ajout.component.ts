import { Component, OnInit } from '@angular/core';
import {ClasseService} from "../../shared/service/classe.service";
import {Router} from "@angular/router";
import {SuccessService} from "../../shared/service/success.service";
import {Entreprise} from "../../model/entreprise.model";
import {Classe} from "../../model/classe.model";
import {Etudiant} from "../../model/etudiant.model";

@Component({
  selector: 'app-stagiaire-ajout',
  templateUrl: './stagiaire-ajout.component.html',
  styleUrls: ['./stagiaire-ajout.component.css']
})
export class StagiaireAjoutComponent implements OnInit {

    public classes : Classe[] = [];
    public classe : string = '';
    public stagiaire : Etudiant = {};

  constructor(private classe_service : ClasseService, private router: Router,
              private success_service : SuccessService) { }

  async ngOnInit(): Promise<void> {
      this.classes = await this.classe_service.findAllClasse();
  }

  public compare(a: any, b: any): boolean {
        return a && b ? a.id === b.id : a === b
  }

}

import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../shared/service/authentification.service";
import {Etudiant} from "../model/etudiant.model";
import {Professeur} from "../model/professeur.model";
import {Classe} from "../model/classe.model";
import {EtudiantService} from "../shared/service/etudiant.service";
import {ProfesseurService} from "../shared/service/professeur.service";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
    public stagiaires :  Etudiant[] = [];
    public professeurs : Professeur[] = [];
    public stagiaire : Etudiant = {};
    public professeur : Professeur = {};


  constructor(private authentificationService : AuthentificationService, private stagiaireService : EtudiantService, private professeurService : ProfesseurService) { }

  async ngOnInit(): Promise<void> {
      this.stagiaires = await this.stagiaireService.findAllEtudiant();
      this.professeurs = await this.professeurService.findAllProfesseur();
  }
    public compare(a: any, b: any): boolean {
        return a && b ? a.id === b.id : a === b
    }
    get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
    }

}

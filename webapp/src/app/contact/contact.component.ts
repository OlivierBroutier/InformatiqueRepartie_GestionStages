import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../shared/service/authentification.service";
import {Etudiant} from "../model/etudiant.model";
import {Professeur} from "../model/professeur.model";
import {Classe} from "../model/classe.model";
import {EtudiantService} from "../shared/service/etudiant.service";
import {ProfesseurService} from "../shared/service/professeur.service";
import {Message} from "../model/message.model";
import {MessageUtilisateur} from "../model/messageUtilisateur.model";
import {MessageService} from "../shared/service/message.service";

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
    public stagiaires: Etudiant[] = [];
    public professeurs: Professeur[] = [];
    public stagiaire: Etudiant = {};
    public professeur: Professeur = {};
    public sujet: string= '';
    public message: string= '';
    public destinataire: string='';


    constructor(private authentificationService: AuthentificationService, private stagiaireService: EtudiantService, private professeurService: ProfesseurService, private messageService : MessageService) {
    }

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

    public async envoyer_message(): Promise<void> {
        let message : Message = {destinataires:[]};
        if(this.stagiaire.id) {
           let message_utilisateur :  MessageUtilisateur = {id:this.stagiaire.id, messageUtilisateurType:'stagiaire'};
           message.destinataires?.push(message_utilisateur);
        }
        if(this.professeur.id){
            let message_utilisateur :  MessageUtilisateur = {id:this.professeur.id, messageUtilisateurType:'professeur'};
            message.destinataires?.push(message_utilisateur);
        }
        if(this.userIsProfesseur==true) {
            let message_exp: MessageUtilisateur = {
                id: this.authentificationService.professeur?.id,
                messageUtilisateurType: 'professeur'
            }
            message.expediteur = message_exp;
        }
        else {
            let message_exp: MessageUtilisateur = {
                id: this.authentificationService.etudiant?.id,
                messageUtilisateurType: 'stagiaire'
            }
            message.expediteur = message_exp;
        }
        message.sujet = this.sujet;
        message.message = this.message;
        this.messageService.ajoutMessage(message);


    }
}

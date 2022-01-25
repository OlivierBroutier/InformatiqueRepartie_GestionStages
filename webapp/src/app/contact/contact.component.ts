import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../shared/service/authentification.service';
import { Etudiant } from '../model/etudiant.model';
import { Professeur } from '../model/professeur.model';
import { EtudiantService } from '../shared/service/etudiant.service';
import { ProfesseurService } from '../shared/service/professeur.service';
import { Message } from '../model/message.model';
import { MessageUtilisateur } from '../model/messageUtilisateur.model';
import { MessageService } from '../shared/service/message.service';
import { MessageUtilisateurTypeEnum } from '../model/message-utilisateur-type.enum';
import { SuccessService } from '../shared/service/success.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
    public stagiaires: Etudiant[] = [];
    public professeurs: Professeur[] = [];
    public stagiaire: Etudiant | undefined;
    public professeur: Professeur | undefined;
    public sujet: string= '';
    public message: string= '';


    constructor(
        private authentificationService: AuthentificationService,
        private stagiaireService: EtudiantService,
        private professeurService: ProfesseurService,
        private messageService : MessageService,
        private successService: SuccessService
    ) {
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
        let message : Message = { destinataires:[] };
        if (this.stagiaire?.id) {
           let message_utilisateur :  MessageUtilisateur = { id: this.stagiaire.id, messageUtilisateurType: MessageUtilisateurTypeEnum.ETUDIANT };
           message.destinataires?.push(message_utilisateur);
        } else if (this.stagiaire === 'tous') {
            for (const etudiant of this.stagiaires) {
                message.destinataires?.push({
                   id: etudiant.id,
                   messageUtilisateurType: MessageUtilisateurTypeEnum.ETUDIANT
                });
            }
        }

        if (this.professeur?.id){
            let message_utilisateur :  MessageUtilisateur = { id: this.professeur.id, messageUtilisateurType: MessageUtilisateurTypeEnum.PROFESSEUR };
            message.destinataires?.push(message_utilisateur);
        } else if (this.professeur === 'tous') {
            for (const professeur of this.professeurs) {
                message.destinataires?.push({
                    id: professeur.id,
                    messageUtilisateurType: MessageUtilisateurTypeEnum.PROFESSEUR
                })
            }
        }

        if (this.userIsProfesseur) {
            message.expediteur = {
                id: this.authentificationService.professeur?.id,
                messageUtilisateurType: MessageUtilisateurTypeEnum.PROFESSEUR
            };
        } else {
            message.expediteur = {
                id: this.authentificationService.etudiant?.id,
                messageUtilisateurType: MessageUtilisateurTypeEnum.ETUDIANT
            };
        }

        message.sujet = this.sujet;
        message.message = this.message;

        await this.messageService.ajoutMessage(message);
        this.successService.createSuccessAlert('Succès', 'Le message a bien été envoyé');
        this.clearFormulaire();
    }

    private clearFormulaire(): void {
        this.sujet = '';
        this.message = '';
        this.stagiaire = undefined;
        this.professeur = undefined;
    }
}

import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../shared/service/authentification.service';
import { Message } from '../model/message.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MessagePopupComponent } from '../message-popup/message-popup.component';
import { MessageUtilisateurTypeEnum } from '../model/message-utilisateur-type.enum';
import { MessageUtilisateur } from '../model/messageUtilisateur.model';
import {MessageService} from "../shared/service/message.service";
import { SuccessService } from '../shared/service/success.service';

@Component({
    selector: 'app-messagerie',
    templateUrl: './messagerie.component.html',
    styleUrls: ['./messagerie.component.css']
})
export class MessagerieComponent implements OnInit {


    constructor(
        private authentificationService : AuthentificationService,
        private modalService : NgbModal,
        private messageService : MessageService,
        private successService: SuccessService
    ) { }

    ngOnInit(): void {
    }

    get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
    }

    get message_envoye() : Message[] {
        if(this.userIsProfesseur) {
            return this.authentificationService.professeur?.messagesEnvoyes?.filter(m =>
                !this.getMessageUtilisateurFromAuthentification(m)?.supprime) ?? [];
        }
        else {
            return this.authentificationService.etudiant?.messagesEnvoyes?.filter(m =>
                !this.getMessageUtilisateurFromAuthentification(m)?.supprime) ?? [];
        }
    }

    set message_envoye(messageEnvoyes: Message[]) {
        if(this.userIsProfesseur && this.authentificationService.professeur) {
            this.authentificationService.professeur.messagesEnvoyes = messageEnvoyes;
        }
        else if (this.authentificationService.etudiant) {
            this.authentificationService.etudiant.messagesEnvoyes = messageEnvoyes;
        }
    }

    get message_recue() : Message[] {
        if(this.userIsProfesseur) {
            return this.authentificationService.professeur?.messagesRecus?.filter(m =>
                !this.getMessageUtilisateurFromAuthentification(m)?.supprime) ?? [];
        }
        else {
            return this.authentificationService.etudiant?.messagesRecus?.filter(m =>
                !this.getMessageUtilisateurFromAuthentification(m)?.supprime) ?? [];
        }
    }

    set message_recue(messagesRecus: Message[]) {
        if(this.userIsProfesseur && this.authentificationService.professeur) {
            this.authentificationService.professeur.messagesRecus = messagesRecus;
        }
        else if (this.authentificationService.etudiant) {
            this.authentificationService.etudiant.messagesRecus = messagesRecus;
        }
    }

    public consult(message?: Message) {
        let popup =this.modalService.open(MessagePopupComponent);
        popup.componentInstance.message = message ?? { };
        popup.result.then(r => {
            if (r.delete && message) {
                this.delete(message);
            }
        })
    }

    public isLu(message?: Message) {
        return this.getMessageUtilisateurFromAuthentification(message)?.lu;
    }

    public isSupprime(message?: Message) {
        return this.getMessageUtilisateurFromAuthentification(message)?.supprime;
    }

    private getMessageUtilisateurFromAuthentification(message?: Message): MessageUtilisateur | undefined {
        if (!message) {
            return undefined;
        }

        if (this.userIsProfesseur) {
            if (message.expediteur?.messageUtilisateurType === MessageUtilisateurTypeEnum.PROFESSEUR
                && message.expediteur?.id === this.authentificationService.professeur?.id) {
                return message.expediteur;
            }
            const destinataire = message?.destinataires?.filter(d => d.messageUtilisateurType === MessageUtilisateurTypeEnum.PROFESSEUR)
                .find(d => d.id === this.authentificationService.professeur?.id);
            if (destinataire) {
                return destinataire;
            }
        } else {
            if (message?.expediteur?.messageUtilisateurType === MessageUtilisateurTypeEnum.ETUDIANT
                && message?.expediteur?.id === this.authentificationService.etudiant?.id) {
                return message.expediteur
            }
            const destinataire = message?.destinataires?.filter(d => d.messageUtilisateurType === MessageUtilisateurTypeEnum.ETUDIANT)
                .find(d => d.id === this.authentificationService.etudiant?.id);
            if (destinataire) {
                return destinataire;
            }
        }
        return undefined;
    }

    async delete(message: Message) : Promise<void> {
        if(this.userIsProfesseur) {
            await this.messageService.markAsSupprimeForProfesseur(message, this.authentificationService.professeur);
        }
        else {
            await this.messageService.markAsSupprimeForEtudiant(message, this.authentificationService.etudiant);
        }

        const messageUtilisateur = this.getMessageUtilisateurFromAuthentification(message);
        if (messageUtilisateur) {
            messageUtilisateur.supprime = true;
        }

        this.successService.createSuccessAlert('Succès', 'Le message a bien été supprimé');
    }
}

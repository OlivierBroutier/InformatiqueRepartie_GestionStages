import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Message} from "../../model/message.model";
import { Professeur } from '../../model/professeur.model';
import { Etudiant } from '../../model/etudiant.model';
import { Utilisateur } from '../../model/utilisateur.model';
import { MessageUtilisateur } from '../../model/messageUtilisateur.model';
import { MessageUtilisateurTypeEnum } from '../../model/message-utilisateur-type.enum';
import { AuthentificationService } from './authentification.service';
@Injectable({
    providedIn: 'root'
})
export class MessageService {

    private apiUrl = environment.apiUrl;

    constructor(
        private readonly httpClient: HttpClient,
        private authentificationService: AuthentificationService
    ) { }

    public get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
    }

    public findAllMessage(): Promise<Message[]> {
        return this.httpClient.get<Message[]>(this.apiUrl + 'message').toPromise();
    }

    public ajoutMessage(message: Message): Promise<Message> {
        return this.httpClient.post(this.apiUrl + 'message', message).toPromise();
    }

    /** Méthodes pour lu & supprimé **/

    public markAsLuForEtudiant(message?: Message, etudiant?: Etudiant) {
        return this.markAsLu(message, { etudiant })
    }

    public markAsLuForProfesseur(message?: Message, professeur?: Professeur) {
        return this.markAsLu(message, { professeur })
    }

    public markAsSupprimeForEtudiant(message?: Message, etudiant?: Etudiant) {
        return this.markAsSupprime(message, { etudiant })
    }

    public markAsSupprimeForProfesseur(message?: Message, professeur?: Professeur) {
        return this.markAsSupprime(message, { professeur })
    }

    /** ------------------------------ */

    private markAsLu(message?: Message, utilisateur?: Utilisateur) {
        return this.httpClient.put<Message>(this.apiUrl + 'message/' + message?.id + '/lu', utilisateur).toPromise();
    }

    private markAsSupprime(message?: Message, utilisateur?: Utilisateur) {
        return this.httpClient.put<Message>(this.apiUrl + 'message/' + message?.id + '/supprime', utilisateur).toPromise();
    }

    public getMessageUtilisateurFromAuthentification(message?: Message): MessageUtilisateur | undefined {
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

}

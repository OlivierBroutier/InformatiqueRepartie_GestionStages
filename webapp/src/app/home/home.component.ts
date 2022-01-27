import { Component, OnInit } from '@angular/core';
import { MessageService } from '../shared/service/message.service';
import { AuthentificationService } from '../shared/service/authentification.service';
import { Message } from '../model/message.model';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    public countNonLus = 0;

    constructor(
        private messageService: MessageService,
        private authentificationService: AuthentificationService
    ) { }

    ngOnInit(): void {
        let messagesRecus: Message[] = [];
        if (this.authentificationService.userIsProfesseur && this.authentificationService.professeur) {
            messagesRecus = this.authentificationService.professeur.messagesRecus ?? [];
        } else if (this.authentificationService.etudiant) {
            messagesRecus = this.authentificationService.etudiant.messagesRecus ?? [];
        }

        for (let message of messagesRecus) {
            const messageUtilisateur = this.messageService.getMessageUtilisateurFromAuthentification(message);
            if (messageUtilisateur && !messageUtilisateur.supprime && !messageUtilisateur.lu) {
                this.countNonLus++;
            }
        }
    }

    get labelMessagesNonLus(): string {
        if (this.countNonLus === 0) {
            return '';
        } else if (this.countNonLus === 1) {
            return 'Vous avez 1 message non lu';
        } else {
            return 'Vous avez ' + this.countNonLus + ' messages non lus';
        }
    }

}

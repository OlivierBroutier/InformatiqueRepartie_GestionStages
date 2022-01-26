import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../shared/service/authentification.service';
import { Message } from '../model/message.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MessagePopupComponent } from '../message-popup/message-popup.component';
import { MessageUtilisateurTypeEnum } from '../model/message-utilisateur-type.enum';
import { MessageUtilisateur } from '../model/messageUtilisateur.model';

@Component({
  selector: 'app-messagerie',
  templateUrl: './messagerie.component.html',
  styleUrls: ['./messagerie.component.css']
})
export class MessagerieComponent implements OnInit {


  constructor(private authentificationService : AuthentificationService, private modalService : NgbModal) { }

  ngOnInit(): void {
  }

  get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
  }

  get message_envoye() : Message[] {
      if(this.userIsProfesseur==true) {
          return this.authentificationService.professeur?.messagesEnvoyes??[];
      }
      else {
          return this.authentificationService.etudiant?.messagesEnvoyes??[];
      }

  }

  get message_recue() : Message[] {
      if(this.userIsProfesseur==true) {
          return this.authentificationService.professeur?.messagesRecus??[];
      }
      else {
          return this.authentificationService.etudiant?.messagesRecus??[];
      }
  }

  public consult(message?: Message) {
      let popup =this.modalService.open(MessagePopupComponent);
      popup.componentInstance.message = message??{};
  }

  public isLu(message?: Message) {
      return this.getMessageEtudiantFromAuthentification(message)?.lu;
  }

  public isSupprime(message?: Message) {
      return this.getMessageEtudiantFromAuthentification(message)?.supprime;
  }

  private getMessageEtudiantFromAuthentification(message?: Message): MessageUtilisateur | undefined {
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

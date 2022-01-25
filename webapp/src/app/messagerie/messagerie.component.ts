import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../shared/service/authentification.service";
import {Message} from "../model/message.model";
import {MDBModalService} from "angular-bootstrap-md";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {MessagePopupComponent} from "../message-popup/message-popup.component";

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

}

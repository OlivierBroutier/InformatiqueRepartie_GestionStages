import { Component, OnInit } from '@angular/core';
import {Message} from "../model/message.model";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-message-popup',
  templateUrl: './message-popup.component.html',
  styleUrls: ['./message-popup.component.css']
})
export class MessagePopupComponent implements OnInit {

    public message : Message={};
  constructor(private modal: NgbActiveModal) { }

  ngOnInit(): void {
  }

    public ferme() {
      this.modal.close();

    }
}

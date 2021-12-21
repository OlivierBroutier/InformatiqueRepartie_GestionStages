import { Component, OnInit } from '@angular/core';
import {Entreprise} from "../model/entreprise.model";
import {EntrepriseService} from "../shared/service/entreprise.service";

@Component({
  selector: 'app-entreprise',
  templateUrl: './entreprise.component.html',
  styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent implements OnInit {

    public entreprises : Entreprise[] = [];
  constructor(private entreprise_service : EntrepriseService) { }

  async ngOnInit(): Promise<void> {
      this.entreprises = await this.entreprise_service.findAllEntreprise();
  }

}

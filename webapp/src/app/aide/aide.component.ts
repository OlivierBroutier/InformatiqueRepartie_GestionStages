import { Component, OnInit } from '@angular/core';
import {AuthentificationService} from "../shared/service/authentification.service";

@Component({
    selector: 'app-aide',
    templateUrl: './aide.component.html',
    styleUrls: ['./aide.component.css']
})
export class AideComponent implements OnInit {

    public expand: boolean = false;

    constructor(private readonly authentificationService: AuthentificationService) { }

    ngOnInit(): void {
    }

    get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
    }

}

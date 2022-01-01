import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from '../shared/service/authentification.service';

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html',
    styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

    constructor(
        private readonly authentificationService: AuthentificationService
    ) { }

    ngOnInit(): void {
    }

    get isLoggedIn(): boolean {
        return this.authentificationService.isLoggedIn;
    }

    get userIsEtudiant(): boolean {
        return this.authentificationService.userIsEtudiant;
    }

    get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
    }

    get utilisateurName(): string {
        if (this.authentificationService.etudiant) {
            return this.authentificationService.etudiant.nomEtudiant
                + ' ' + this.authentificationService.etudiant.prenomEtudiant;
        } else if (this.authentificationService.professeur) {
            return this.authentificationService.professeur.nomProf
                + ' ' + this.authentificationService.professeur.prenomProf;
        } else {
            return '';
        }
    }

    public disconnect(): void {
        this.authentificationService.disconnect();

        location.reload();
    }

}

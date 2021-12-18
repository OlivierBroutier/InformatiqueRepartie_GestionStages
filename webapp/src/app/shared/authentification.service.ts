import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Etudiant } from '../model/etudiant.model';
import { Professeur } from '../model/professeur.model';
import { Login } from '../model/login.model';
import { Utilisateur } from '../model/utilisateur.model';

@Injectable({
    providedIn: 'root'
})
export class AuthentificationService {

    public etudiant?: Etudiant;
    public professeur?: Professeur;

    private apiUrl = environment.apiUrl;

    constructor(
        private http: HttpClient
    ) { }

    get isLoggedIn(): boolean {
        return !!this.etudiant || !!this.professeur;
    }

    get userIsEtudiant(): boolean {
        return this.isLoggedIn && !!this.etudiant;
    }

    get userIsProfesseur(): boolean {
        return this.isLoggedIn && !!this.professeur;
    }

    private url(sub: string = ''): string {
        return this.apiUrl + 'login/' + sub;
    }

    public async login(login: Login): Promise<void> {
        const result = await this.http.post<Utilisateur>(this.url(), login).toPromise();
        if (result) {
            this.etudiant = result.etudiant;
            this.professeur = result.professeur;
        }
    }

}

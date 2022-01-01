import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Etudiant } from '../../model/etudiant.model';
import { Professeur } from '../../model/professeur.model';
import { Login } from '../../model/login.model';
import { Utilisateur } from '../../model/utilisateur.model';

@Injectable({
    providedIn: 'root'
})
export class AuthentificationService {

    public etudiant?: Etudiant;
    public professeur?: Professeur;

    private apiUrl = environment.apiUrl;

    constructor(
        private http: HttpClient
    ) {
        const localEtudiant = window.localStorage.getItem('etudiant');
        if (localEtudiant) {
            this.etudiant = JSON.parse(localEtudiant);
        }

        const localProfesseur = window.localStorage.getItem('professeur');
        if (localProfesseur) {
            this.professeur = JSON.parse(localProfesseur);
        }
    }

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

            window.localStorage.setItem('etudiant', JSON.stringify(result.etudiant));
            window.localStorage.setItem('professeur', JSON.stringify(result.professeur));
        }
    }

    public disconnect(): void {
        this.etudiant = undefined;
        this.professeur = undefined;

        window.localStorage.clear();
    }

}

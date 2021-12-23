import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Professeur} from "../../model/professeur.model";

@Injectable({
    providedIn: 'root'
})
export class ProfesseurService {

    private apiUrl = environment.apiUrl;

    constructor(private httpClient : HttpClient) { }

    public findAllProfesseur() : Promise<Professeur[]> {
        return this.httpClient.get<Professeur[]>(this.apiUrl + 'professeur').toPromise();
    }
}

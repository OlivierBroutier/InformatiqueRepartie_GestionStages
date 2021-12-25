import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Etudiant} from "../../model/etudiant.model";

@Injectable({
    providedIn: 'root'
})
export class EtudiantService {

    private apiUrl = environment.apiUrl;

    constructor(private httpClient : HttpClient) { }

    public findAllEtudiant() : Promise<Etudiant[]> {
        return this.httpClient.get<Etudiant[]>(this.apiUrl + 'etudiant').toPromise();
    }
}
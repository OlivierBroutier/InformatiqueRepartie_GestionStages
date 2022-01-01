import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Etudiant} from "../../model/etudiant.model";

@Injectable({
    providedIn: 'root'
})
export class EtudiantService {

    private apiUrl = environment.apiUrl;

    constructor(
        private readonly httpClient: HttpClient
    ) { }

    public findAllEtudiant(): Promise<Etudiant[]> {
        return this.httpClient.get<Etudiant[]>(this.apiUrl + 'etudiant').toPromise();
    }

    public ajoutEtudiant(etudiant: Etudiant): Promise<Etudiant> {
        return this.httpClient.post(this.apiUrl + 'etudiant', etudiant).toPromise();
    }

    public updateEtudiant(etudiant: Etudiant): Promise<Etudiant> {
        return this.httpClient.put<Etudiant>(this.apiUrl + 'etudiant/' + etudiant.id, etudiant).toPromise();
    }

    public findEtudiantById(id: string): Promise<Etudiant> {
        return this.httpClient.get<Etudiant>(this.apiUrl + 'etudiant/' + id).toPromise();
    }

    public deleteEntreprise(id: string): Promise<void> {
        return this.httpClient.delete<void>(this.apiUrl + 'etudiant/' + id).toPromise();
    }
}

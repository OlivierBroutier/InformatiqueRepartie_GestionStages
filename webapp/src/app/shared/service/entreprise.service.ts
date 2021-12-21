import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Entreprise } from '../../model/entreprise.model';

@Injectable({
    providedIn: 'root'
})
export class EntrepriseService {

    private apiUrl = environment.apiUrl;

    constructor(private httpClient : HttpClient) { }

    public findAllEntreprise() : Promise<Entreprise[]> {
        return this.httpClient.get<Entreprise[]>(this.apiUrl + 'entreprise').toPromise();
    }

    public findEntrepriseById(id: string) : Promise<Entreprise> {
        return this.httpClient.get<Entreprise>(this.apiUrl + 'entreprise/'+id).toPromise();
    }
}

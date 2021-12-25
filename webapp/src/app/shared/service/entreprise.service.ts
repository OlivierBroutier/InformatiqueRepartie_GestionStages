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

    public ajoutEntreprise(entreprise: Entreprise) : Promise<Entreprise> {
        return this.httpClient.post<Entreprise>(this.apiUrl+'entreprise', entreprise).toPromise();
    }

    public updateEntreprise(entreprise: Entreprise): Promise<Entreprise> {
        return this.httpClient.put<Entreprise>(this.apiUrl + 'entreprise/' + entreprise.id, entreprise).toPromise();
    }

    public deleteEntreprise(id : string) : Promise<void> {
        return this.httpClient.delete<void>(this.apiUrl + 'entreprise/'+ id).toPromise();
    }
}

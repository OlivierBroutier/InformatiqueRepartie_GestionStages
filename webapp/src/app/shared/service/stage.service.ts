import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Stage } from '../../model/stage.model';
import { Etudiant } from '../../model/etudiant.model';

@Injectable({
    providedIn: 'root'
})
export class StageService {

    private apiUrl = environment.apiUrl;

    constructor(
        private readonly httpClient : HttpClient
    ) { }

    public findAllStage(): Promise<Stage[]> {
        return this.httpClient.get<Stage[]>(this.apiUrl + 'stage').toPromise();
    }

    public findAllByEtudiant(etudiant: Etudiant): Promise<Stage[]> {
        return this.httpClient.get<Stage[]>(this.apiUrl + 'stage/etudiant/' + etudiant.id).toPromise();
    }

    public ajoutStage(stage: Stage): Promise<Stage> {
        return this.httpClient.post<Stage>(this.apiUrl + 'stage', stage).toPromise();
    }

    public findStageById(id: string) : Promise<Stage> {
        return this.httpClient.get<Stage>(this.apiUrl + 'stage/' + id).toPromise();
    }

    public modifStage(stage: Stage) : Promise<Stage> {
        return this.httpClient.put<Stage>(this.apiUrl + 'stage', stage).toPromise();
    }

    public deleteStage(id: string) : Promise<void> {
        return this.httpClient.delete<void>(this.apiUrl + 'stage/' + id).toPromise();
    }
}

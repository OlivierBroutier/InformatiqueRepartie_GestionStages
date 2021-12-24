import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Stage } from '../../model/stage.model';

@Injectable({
    providedIn: 'root'
})
export class StageService {

    private apiUrl = environment.apiUrl;

    constructor(private httpClient : HttpClient) { }

    public findAllStage() : Promise<Stage[]> {
        return this.httpClient.get<Stage[]>(this.apiUrl + 'stage').toPromise();
    }

    public findStageByEntrepriseId(id: string) : Promise<Stage[]>{
        return this.httpClient.get<Stage[]>(this.apiUrl + 'stage/entreprise/'+id).toPromise();
    }

    public ajoutStage(stage: Stage) : Promise<Stage> {
        return this.httpClient.post<Stage>(this.apiUrl + 'stage',stage).toPromise();
    }
}

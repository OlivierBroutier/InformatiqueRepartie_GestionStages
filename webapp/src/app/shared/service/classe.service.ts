import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Stage} from "../../model/stage.model";
import {Classe} from "../../model/classe.model";

@Injectable({
    providedIn: 'root'
})
export class ClasseService {

    private apiUrl = environment.apiUrl;

    constructor(private httpClient : HttpClient) { }

    public findAllClasse() : Promise<Classe[]> {
        return this.httpClient.get<Classe[]>(this.apiUrl + 'classe').toPromise();
    }
}

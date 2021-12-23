import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Entreprise} from "../../model/entreprise.model";
import {Specialite} from "../../model/specialite.model";

@Injectable({
  providedIn: 'root'
})
export class SpecialiteService {

    private apiUrl = environment.apiUrl;

    constructor(private httpClient : HttpClient) { }

    public findAllSpecialite() : Promise<Specialite[]> {
        return this.httpClient.get<Specialite[]>(this.apiUrl + 'specialite').toPromise();
    }
}






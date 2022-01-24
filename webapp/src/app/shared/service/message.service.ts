import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Message} from "../../model/message.model";
@Injectable({
    providedIn: 'root'
})
export class MessageService {

    private apiUrl = environment.apiUrl;

    constructor(
        private readonly httpClient: HttpClient
    ) { }

    public findAllMessage(): Promise<Message[]> {
        return this.httpClient.get<Message[]>(this.apiUrl + 'message').toPromise();
    }

    public ajoutMessage(message: Message): Promise<Message> {
        return this.httpClient.post(this.apiUrl + 'message', message).toPromise();
    }

}

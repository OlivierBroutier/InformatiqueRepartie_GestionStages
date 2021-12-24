import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { OgiSuccess } from '../model/ogi-alert.model';

@Injectable({
    providedIn: 'root'
})
export class SuccessService {

    private readonly successBehavior: BehaviorSubject<any> = new BehaviorSubject<OgiSuccess | undefined>(undefined);
    public success = this.successBehavior.asObservable();

    constructor() { }

    public buildSuccess(nameValue: string, messageValue: string): OgiSuccess {
        return new OgiSuccess(nameValue, messageValue);
    }

    public handle(success: OgiSuccess): void {
        if (success.message === undefined || success.message === null) {
            success.message = `Succès de l'opération`;
        }
        console.log(success);
        this.successBehavior.next(success);
    }

    public createSuccessAlert(name: string, message: string): void {
        this.handle(this.buildSuccess(name, message));
    }
}

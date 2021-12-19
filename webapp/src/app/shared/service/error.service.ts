import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { OgiAlert, OgiError } from '../model/ogi-alert.model';

@Injectable({
  providedIn: 'root'
})
export class ErrorService {

  private readonly errorBehavior: BehaviorSubject<any> = new BehaviorSubject<OgiError | undefined>(undefined);
  public error = this.errorBehavior.asObservable();

  constructor() { }

  public handle(e: OgiAlert): void {
    if (!e) {
      e = new OgiError('Erreur sans nom', undefined);
    }

    if (e.message === undefined || e.message === null) {
      e.message = `Une erreur est survenue lors d'un appel au serveur`;
    }

    this.errorBehavior.next(e);
  }
}

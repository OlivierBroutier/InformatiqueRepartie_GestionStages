import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorService } from '../service/error.service';
import { OgiError } from '../model/ogi-alert.model';

@Injectable()
export class HttpDefaultInterceptor implements HttpInterceptor {

    constructor(
        private readonly errorService: ErrorService
    ) {
    }

    public intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(req).pipe(
            catchError(({ error, status, name, message }: HttpErrorResponse) => {
                const ogiAlert = error ?
                    new OgiError(name, error.message, error.code, error.details)
                    : new OgiError(name, message);
                this.errorService.handle(ogiAlert);
                return throwError(ogiAlert);
            })
        );
    }
}

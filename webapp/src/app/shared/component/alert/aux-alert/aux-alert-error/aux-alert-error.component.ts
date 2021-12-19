import { Component, OnInit } from '@angular/core';
import { AuxAlertBaseComponent } from '../aux-alert-base.component';
import { OgiError } from '../../../../model/ogi-alert.model';

@Component({
    selector: 'app-aux-alert-error',
    templateUrl: './aux-alert-error.component.html',
    styleUrls: ['./aux-alert-error.component.scss']
})
export class AuxAlertErrorComponent extends AuxAlertBaseComponent implements OnInit {

    constructor() {
        super();
    }

    ngOnInit(): void { }

    get error(): OgiError {
        return this.ogiAlert as OgiError;
    }

}

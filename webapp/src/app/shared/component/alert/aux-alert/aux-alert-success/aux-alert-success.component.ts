import { Component, OnInit } from '@angular/core';
import { AuxAlertBaseComponent } from '../aux-alert-base.component';
import { OgiSuccess } from '../../../../model/ogi-alert.model';

@Component({
    selector: 'app-aux-alert-success',
    templateUrl: './aux-alert-success.component.html',
    styleUrls: ['./aux-alert-success.component.scss']
})
export class AuxAlertSuccessComponent extends AuxAlertBaseComponent implements OnInit {

    constructor() {
        super();
    }

    ngOnInit(): void { }

    get success(): OgiSuccess {
        return this.ogiAlert as OgiSuccess;
    }

}

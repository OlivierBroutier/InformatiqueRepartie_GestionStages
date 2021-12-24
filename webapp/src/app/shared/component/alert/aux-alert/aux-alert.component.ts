import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { OgiAlert } from '../../../model/ogi-alert.model';
import { AuxAlertEnum } from '../../../model/aux-alert.enum';

@Component({
    selector: 'app-aux-alert',
    templateUrl: './aux-alert.component.html',
    styleUrls: ['./aux-alert.component.scss']
})
export class AuxAlertComponent implements OnInit {

    @Input() ogiAlert: OgiAlert = { type: AuxAlertEnum.ERROR };

    @Output() closeEvent: EventEmitter<OgiAlert> = new EventEmitter<OgiAlert>();

    public auxAlertEnum = AuxAlertEnum;

    constructor() { }

    ngOnInit(): void {
        setTimeout(() => {
            this.onClose(this.ogiAlert);
        }, 5000);
    }

    public onClose(ogiAlert: any): void {
        this.closeEvent.emit(ogiAlert);
    }

}

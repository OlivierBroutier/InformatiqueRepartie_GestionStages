import { Component, EventEmitter, Input, Output } from '@angular/core';
import { OgiAlert } from '../../../model/ogi-alert.model';

@Component({ template: '' })
export abstract class AuxAlertBaseComponent {

    @Input() ogiAlert?: OgiAlert;

    @Output() closeEvent: EventEmitter<OgiAlert> = new EventEmitter<OgiAlert>();

    public onClose(): void {
        this.closeEvent.emit(this.ogiAlert);
    }

}

import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
    selector: 'app-confirmation-popup',
    templateUrl: './confirmation-popup.component.html',
    styleUrls: ['./confirmation-popup.component.css']
})
export class ConfirmationPopupComponent implements OnInit {

    message: string = '';

    constructor(
        private activeModal: NgbActiveModal
    ) { }

    ngOnInit(): void {
    }

    public confirm(): void {
        this.activeModal.close(true);
    }

    public cancel(): void {
        this.activeModal.dismiss();
    }

}

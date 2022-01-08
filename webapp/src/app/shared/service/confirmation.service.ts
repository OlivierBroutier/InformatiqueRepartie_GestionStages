import { Injectable } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmationPopupComponent } from '../../confirmation-popup/confirmation-popup.component';

@Injectable({
    providedIn: 'root'
})
export class ConfirmationService {

    constructor(
        private readonly modalService: NgbModal
    ) { }

    public async confirmation(message: string): Promise<any> {
        const modalRef = this.modalService.open(ConfirmationPopupComponent);
        modalRef.componentInstance.message = message;

        return modalRef.result;
    }

}

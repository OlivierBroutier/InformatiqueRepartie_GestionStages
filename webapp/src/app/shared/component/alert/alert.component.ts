import { Component, OnInit } from '@angular/core';
import { OgiAlert } from '../../model/ogi-alert.model';
import { ErrorService } from '../../service/error.service';
import { SuccessService } from '../../service/success.service';

@Component({
    selector: 'app-alert',
    templateUrl: './alert.component.html',
    styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit {

    public alerts: OgiAlert[] = [];

    constructor(
        private readonly successService: SuccessService,
        private readonly errorService: ErrorService
    ) { }

    ngOnInit(): void {
        this.successService.success.subscribe((success: any) => {
            this.addAlert(success);
        });
        this.errorService.error.subscribe((error: any) => {
            this.addAlert(error);
        });
    }

    private addAlert(alert: OgiAlert): void {
        if (alert !== undefined && !this.alerts.find(s => s.message === alert.message)) {
            this.alerts.push(alert);
        }
    }

    public onAlertClose(alert: any): void {
        this.alerts = this.alerts.filter(a => a !== alert);
    }

}

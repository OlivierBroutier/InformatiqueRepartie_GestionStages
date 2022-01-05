import { Component, OnInit } from '@angular/core';
import { Stage } from '../model/stage.model';
import { StageService } from '../shared/service/stage.service';
import { Router } from "@angular/router";
import { SuccessService } from "../shared/service/success.service";
import {jsPDF} from "jspdf";
import { ViewChild, ElementRef } from '@angular/core';
import 'jspdf-autotable';
import {UserOptions} from "jspdf-autotable";

interface jsPDFCustom extends jsPDF {
    autoTable: (options: UserOptions) => void;
}

@Component({
    selector: 'app-stage',
    templateUrl: './stage.component.html',
    styleUrls: ['./stage.component.css']
})
export class StageComponent implements OnInit {
    @ViewChild('pdfTable') pdfTable: ElementRef | undefined;
    public stages : Stage[] = [];

    constructor(
        private readonly stage_service : StageService,
        private readonly router: Router,
        private readonly success_service : SuccessService
    ) { }

    async ngOnInit(): Promise<void> {
        this.stages = await this.stage_service.findAllStage();
    }

    get nbStages(): string {
        if (this.stages.length === 0) {
            return 'Aucun stage trouvé';
        } else if (this.stages.length === 1) {
            return '1 stage trouvé';
        } else {
            return this.stages.length + ' stages trouvés';
        }
    }

    public editStage(stage: Stage) : void {
        this.router.navigate(['/stage/modif/'+stage.id], { state: { stage } });
    }

    public async removeStage(stage: Stage) : Promise<void> {
        if (stage.id) {
            await this.stage_service.deleteStage(String(stage.id));
            this.success_service.createSuccessAlert('Succès', 'Le stage a bien été supprimé');
            this.stages = [...this.stages].filter(e => e.id !== stage.id);
        }
    }

    public downloadAsPDF() {
        const pdfTable = this.pdfTable?.nativeElement;
        const doc = new jsPDF('l', 'pt', 'a4') as jsPDFCustom;
        doc.autoTable({
            html: pdfTable
        });
        doc.save('liste_stage.pdf');
    }
}

import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Stage } from '../model/stage.model';
import { StageService } from '../shared/service/stage.service';
import { Router } from '@angular/router';
import { SuccessService } from '../shared/service/success.service';
import { jsPDF } from 'jspdf';
import { AuthentificationService } from '../shared/service/authentification.service';
import { jsPDFCustom } from '../model/jspdf.model';
import { ConfirmationService } from '../shared/service/confirmation.service';


@Component({
    selector: 'app-stage',
    templateUrl: './stage.component.html',
    styleUrls: ['./stage.component.css']
})
export class StageComponent implements OnInit {

    @ViewChild('pdfTable') pdfTable: ElementRef | undefined;

    public stages : Stage[] = [];

    constructor(
        private readonly stageService: StageService,
        private readonly router: Router,
        private readonly successService: SuccessService,
        private readonly authentificationService: AuthentificationService,
        private readonly confirmationService: ConfirmationService
    ) { }

    async ngOnInit(): Promise<void> {
        if (this.authentificationService.userIsEtudiant && this.authentificationService.etudiant) {
            this.stages = await this.stageService.findAllByEtudiant(this.authentificationService.etudiant);
        } else {
            this.stages = await this.stageService.findAllStage();
        }
    }

    get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
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
        if (!stage.id) {
            return;
        }

        const confirmed = await this.confirmationService.confirmation('Êtes-vous sûr de vouloir supprimer ce stage ?');
        if (confirmed) {
            await this.stageService.deleteStage(String(stage.id));
            this.successService.createSuccessAlert('Succès', 'Le stage a bien été supprimé');
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

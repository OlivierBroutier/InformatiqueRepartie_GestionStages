import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Etudiant } from '../model/etudiant.model';
import { EtudiantService } from '../shared/service/etudiant.service';
import { Router } from '@angular/router';
import { SuccessService } from '../shared/service/success.service';
import { Stage } from '../model/stage.model';
import { StageService } from '../shared/service/stage.service';
import { Entreprise } from '../model/entreprise.model';
import { Professeur } from '../model/professeur.model';
import { jsPDF } from 'jspdf';
import 'jspdf-autotable';
import { UserOptions } from 'jspdf-autotable';

interface jsPDFCustom extends jsPDF {
    autoTable: (options: UserOptions) => void;
}
@Component({
    selector: 'app-stagiaire',
    templateUrl: './stagiaire.component.html',
    styleUrls: ['./stagiaire.component.css']
})
export class StagiaireComponent implements OnInit {
    @ViewChild('pdfTable') pdfTable: ElementRef | undefined;
    public stagiaires : Etudiant[] = [];
    public nom: string = '';
    public stagiaires_find : Etudiant[] = [];
    public stages : Stage[] = [];

    constructor(private readonly stagiaire_service : EtudiantService, private  readonly router : Router, private readonly success_service : SuccessService, private readonly stage_service : StageService) { }

    async ngOnInit(): Promise<void> {
        this.stagiaires = await this.stagiaire_service.findAllEtudiant();
        this.stagiaires_find = this.stagiaires;
    }

    get nbStagiaires(): string {
        if (this.stagiaires_find.length === 0) {
            return 'Aucun stagiaire trouvé';
        } else if (this.stagiaires_find.length === 1) {
            return '1 stagiaire trouvé';
        } else {
            return this.stagiaires_find.length + ' stagiaires trouvés';
        }
    }

    public getLastStage(stagiaire: Etudiant): Stage | undefined {
        if (stagiaire.stages?.length === 0) {
            return undefined;
        }
        return stagiaire.stages?.reduce((a, b) => (a.finStage ?? '') > (b.finStage ?? '') ? a : b);
    }

    public getEntreprise(stagiaire: Etudiant): Entreprise | undefined {
        return this.getLastStage(stagiaire)?.entreprise;
    }

    public getProfesseur(stagiaire: Etudiant): Professeur | undefined {
        return this.getLastStage(stagiaire)?.professeur;
    }

    public navigateToEntreprise(stagiaire: Etudiant): void {
        const entreprise = this.getEntreprise(stagiaire);
        if (entreprise) {
            this.router.navigate(['/entreprise/' + entreprise.id]);
        }
    }

    public rechercher() {
        this.stagiaires_find = [];
        for(let stagiaire of this.stagiaires) {
            if(stagiaire.nomEtudiant?.toLowerCase()?.includes(this.nom.toLowerCase()) || stagiaire.prenomEtudiant?.toLowerCase()?.includes(this.nom.toLowerCase())) {
                this.stagiaires_find.push(stagiaire);
            }
        }


    }

    public async removeEtudiant(stagiaire: Etudiant): Promise<void> {
        if (stagiaire.id) {
            await this.stagiaire_service.deleteEntreprise(String(stagiaire.id));
            this.success_service.createSuccessAlert('Succès', 'L\'étudiant a bien été supprimé');
            this.stagiaires = [...this.stagiaires].filter(e => e.id !== stagiaire.id);
            this.stagiaires_find = [...this.stagiaires_find].filter(e => e.id !== stagiaire.id);
        }

    }

    public editEtudiant(stagiaire: Etudiant) {
        this.router.navigate(['/stagiaire/ajout'], { state: { stagiaire } });
    }

    public inscription(stagiaire: Etudiant): void {
        this.router.navigate(['/inscription'], { state: { stagiaire } });
    }

    public downloadAsPDF() {
        const pdfTable = this.pdfTable?.nativeElement;
        const doc = new jsPDF('l', 'pt', 'a4') as jsPDFCustom;
        doc.autoTable({
            html: pdfTable
        });
        doc.save('liste_etudiant_avec_sans_stage.pdf');
    }
}





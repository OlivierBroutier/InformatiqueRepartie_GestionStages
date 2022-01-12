import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Entreprise } from '../model/entreprise.model';
import { EntrepriseService } from '../shared/service/entreprise.service';
import { Router } from '@angular/router';
import { SuccessService } from '../shared/service/success.service';
import { AuthentificationService } from '../shared/service/authentification.service';
import { jsPDF } from 'jspdf';
import 'jspdf-autotable';
import { jsPDFCustom } from '../model/jspdf.model';
import { ConfirmationService } from '../shared/service/confirmation.service';


@Component({
    selector: 'app-entreprise',
    templateUrl: './entreprise.component.html',
    styleUrls: ['./entreprise.component.css']
})
export class EntrepriseComponent implements OnInit {

    @ViewChild('pdfTable') pdfTable: ElementRef | undefined;

    public entreprises : Entreprise[] = [];
    public nom: string = '';
    public entreprises_find : Entreprise[] = [];

    constructor(
        private readonly entreprise_service : EntrepriseService,
        private readonly router: Router,
        private readonly success_service : SuccessService,
        private readonly authentificationService: AuthentificationService,
        private readonly confirmationService: ConfirmationService
    ) { }

    async ngOnInit(): Promise<void> {
        this.entreprises = await this.entreprise_service.findAllEntreprise();
        this.entreprises_find = this.entreprises;
    }

    get userIsProfesseur(): boolean {
        return this.authentificationService.userIsProfesseur;
    }

    get nbEntreprises(): string {
        if (this.entreprises_find.length === 0) {
            return 'Aucune entreprise trouvée';
        } else if (this.entreprises_find.length === 1) {
            return '1 entreprise trouvée';
        } else {
            return this.entreprises_find.length + ' entreprises trouvées';
        }
    }

    public getSpecialitesLibelle(entreprise: Entreprise): string {
        return entreprise.specialites?.map(specialite => specialite.libelle).join(' / ') ?? 'Aucune';
    }

    public rechercher() {
        this.entreprises_find = [];
        for(let entreprise of this.entreprises) {
            if (entreprise.raisonSociale?.toLowerCase()?.includes(this.nom.toLowerCase())
                || entreprise.nomResp?.toLowerCase()?.includes(this.nom.toLowerCase())) {
                this.entreprises_find.push(entreprise);
            }
        }
    }

    public editEntreprise(entreprise: Entreprise): void {
        this.router.navigate(['/entreprise/ajout'], { state: { entreprise } });
    }

    public inscription(entreprise: Entreprise): void {
        this.router.navigate(['/inscription'], { state: { entreprise } });
    }

    public async removeEntreprise(entreprise: Entreprise): Promise<void> {
        if (!entreprise.id) {
            return;
        }

        const confirmed = await this.confirmationService.confirmation('Êtes-vous sûr de vouloir supprimer cette entreprise ?');
        if (confirmed) {
            await this.entreprise_service.deleteEntreprise(String(entreprise.id));
            this.success_service.createSuccessAlert('Succès', 'L\'entreprise a bien été supprimée');
            this.entreprises = this.entreprises.filter(e => e.id !== entreprise.id);
            this.entreprises_find = this.entreprises_find.filter(e => e.id !== entreprise.id);
        }
    }

    public downloadAsPDF() {
        const pdfTable = this.pdfTable?.nativeElement;
        const doc = new jsPDF('l', 'pt', 'a4') as jsPDFCustom;
        doc.autoTable({
            html: pdfTable
        });
        doc.save('liste_entreprise.pdf');
    }
}

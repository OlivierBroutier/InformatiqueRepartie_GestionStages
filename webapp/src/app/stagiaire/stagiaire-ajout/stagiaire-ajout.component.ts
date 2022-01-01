import { Component, OnInit } from '@angular/core';
import {ClasseService} from "../../shared/service/classe.service";
import {Router} from "@angular/router";
import {SuccessService} from "../../shared/service/success.service";
import {Entreprise} from "../../model/entreprise.model";
import {Classe} from "../../model/classe.model";
import {Etudiant} from "../../model/etudiant.model";
import { EtudiantService } from '../../shared/service/etudiant.service';
import { EntrepriseService } from '../../shared/service/entreprise.service';

@Component({
    selector: 'app-stagiaire-ajout',
    templateUrl: './stagiaire-ajout.component.html',
    styleUrls: ['./stagiaire-ajout.component.css']
})
export class StagiaireAjoutComponent implements OnInit {

    public classes : Classe[] = [];
    public classe : string = '';
    public stagiaire : Etudiant = {};

    constructor(
        private readonly classeService: ClasseService,
        private readonly router: Router,
        private readonly successService: SuccessService,
        private readonly etudiantService : EtudiantService
    ) { }

    async ngOnInit(): Promise<void> {
        this.classes = await this.classeService.findAllClasse();
        this.stagiaire = window.history.state.stagiaire ?? { }
    }

    public get isEditing(): boolean {
        return !!this.stagiaire.id;
    }

    public compare(a: any, b: any): boolean {
        return a && b ? a.id === b.id : a === b
    }

    public async ajout(): Promise<void> {
        await this.etudiantService.ajoutEtudiant(this.stagiaire);
        this.successService.createSuccessAlert('Succès', 'L\'étudiant a bien été créée');
        this.router.navigate(['/stagiaire']);
    }

    public async edit(): Promise<void> {
        this.stagiaire = await this.etudiantService.updateEtudiant(this.stagiaire);
        this.successService.createSuccessAlert('Succès', 'Le stagiaire a bien été modifié');
    }
}

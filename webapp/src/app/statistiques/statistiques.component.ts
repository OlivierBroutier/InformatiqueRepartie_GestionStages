import { Component, OnInit } from '@angular/core';
import {EtudiantService} from "../shared/service/etudiant.service";
import {Etudiant} from "../model/etudiant.model";
import {Entreprise} from "../model/entreprise.model";
import {EntrepriseService} from "../shared/service/entreprise.service";


@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.css']
})
export class StatistiquesComponent implements OnInit {

    public etudiant_groupe : Map<string, number> = new Map<string, number>();
    public entreprise_groupe : Map<string, number> = new Map<string, number>();
    public etudiants: Etudiant[] = [];
    public entreprises: Entreprise[] = [];
    public chartType: string = 'pie';
    public chartDatasets: Array<any> = [];
    public chartDatasets1: Array<any> = [];
    public chartDatasets2: Array<any> = [];
    public chartLabels: Array<any> = [];
    public chartLabels1: Array<any> = [];
    public chartLabels2: Array<any> = [];

    public chartColors: Array<any> = [];

    public chartOptions: any = {
        responsive: true
    };

    constructor(private etudiantService: EtudiantService, private entrepriseService : EntrepriseService) {
    }

    async ngOnInit(): Promise<void> {
        this.etudiants = await this.etudiantService.findAllEtudiant();
        this.entreprises = await this.entrepriseService.findAllEntreprise();
        this.etudiant_groupe = this.groupByClasse(this.etudiants);
        this.entreprise_groupe = this.groupBySpecialite(this.entreprises);
        this.chartDatasets = [{data : [...this.etudiant_groupe.values()]} ];
        this.chartDatasets1 = [{data : [...this.entreprise_groupe.values()]} ];
        this.chartLabels = [...this.etudiant_groupe.keys()];
        this.chartLabels1 = [...this.entreprise_groupe.keys()];

        const nbEtudiantsAvecStage = this.etudiants.filter(e => e.stages && e.stages.length > 0).length;
        this.chartDatasets2 = [{ data: [nbEtudiantsAvecStage, this.etudiants.length - nbEtudiantsAvecStage] }];
        this.chartLabels2 = ['Etudiants avec stage', 'Etudiants sans stage'];
    }

    groupByClasse = (etudiants: Etudiant[]): Map<string, number> => {
          return etudiants.reduce((rv: Map<string, number>, x: Etudiant) => {
              if (!x.classe || !x.classe.nomClasse) {
                  return rv;
              }

              rv.set(x.classe.nomClasse, (rv.get(x.classe.nomClasse) ?? 0) + 1);
              return rv;
          }, new Map());
      }

    groupBySpecialite = (entreprises: Entreprise[]): Map<string, number> => {
        return entreprises.reduce((rv: Map<string, number>, x: Entreprise) => {
            x.specialites?.forEach(specialite => {
                if (!specialite.libelle) {
                    return;
                }

                rv.set(specialite.libelle, (rv.get(specialite.libelle) ?? 0) + 1);
            });
            return rv;
        }, new Map());
    }



    public chartClicked(e: any): void { }
    public chartHovered(e: any): void { }
}






import { Component, OnInit } from '@angular/core';
import {EtudiantService} from "../shared/service/etudiant.service";
import {Etudiant} from "../model/etudiant.model";


@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.css']
})
export class StatistiquesComponent implements OnInit {

    public chartReady = false;
    public etudiant_groupe: Map<string, number> = new Map<string, number>();
    public etudiants: Etudiant[] = [];
    public chartType: string = 'pie';
    public chartDatasets: Array<any> = [
    ];

    public chartLabels: Array<any> = [];

    public chartColors: Array<any> = [];

    public chartOptions: any = {
        responsive: true
    };

    constructor(private etudiantService: EtudiantService) {
    }

    async ngOnInit(): Promise<void> {

        let array_etudiant = [];

        this.etudiants = await this.etudiantService.findAllEtudiant();
        for (let i = 0; i < this.etudiants.length; i++) {
            array_etudiant.push(this.etudiants[i].classe?.nomClasse);


        }
        this.etudiant_groupe = this.groupByClasse(this.etudiants);


        this.chartDatasets = [{data : [...this.etudiant_groupe.values()], label : 'Etudiant selon leurs classes'} ];
        this.chartLabels = [...this.etudiant_groupe.keys()];
        console.log(this.chartDatasets);
        console.log(this.chartLabels);

        this.chartReady = true;
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




    public chartClicked(e: any): void { }
    public chartHovered(e: any): void { }
}






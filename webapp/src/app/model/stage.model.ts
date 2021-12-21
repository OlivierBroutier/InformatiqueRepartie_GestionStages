import {Etudiant} from "./etudiant.model";
import {Professeur} from "./professeur.model";
import {Entreprise} from "./entreprise.model";

export interface Stage {
    id?: number;
    debutStage? : string;
    finStage? : string;
    typeStage? : string;
    descProjet?: string;
    observationStage? : string;
    etudiant? : Etudiant;
    professeur? : Professeur;
    entreprise?: Entreprise;
}

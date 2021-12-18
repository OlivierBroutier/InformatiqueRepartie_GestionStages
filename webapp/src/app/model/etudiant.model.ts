import { Classe } from './classe.model';

export interface Etudiant {
    id?: number;
    nomEtudiant?: string;
    prenomEtudiant?: string;
    anneeObtention?: string;
    login?: string;
    mdp?: string;
    classe?: Classe;
    enActivite?: boolean;
}

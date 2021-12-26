import { Classe } from './classe.model';
import { Stage } from './stage.model';

export interface Etudiant {
    id?: number;
    nomEtudiant?: string;
    prenomEtudiant?: string;
    anneeObtention?: string;
    login?: string;
    classe?: Classe;
    enActivite?: boolean;
    stages?: Stage[];
}

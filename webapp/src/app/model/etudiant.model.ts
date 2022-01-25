import { Classe } from './classe.model';
import { Stage } from './stage.model';
import { Message } from './message.model';

export interface Etudiant {
    id?: number;
    nomEtudiant?: string;
    prenomEtudiant?: string;
    anneeObtention?: string;
    login?: string;
    mdp?: string;
    classe?: Classe;
    enActivite?: boolean;
    stages?: Stage[];
    messagesEnvoyes?: Message[];
}

import { Etudiant } from './etudiant.model';
import { Professeur } from './professeur.model';

export interface Utilisateur {
    etudiant?: Etudiant;
    professeur?: Professeur;
}

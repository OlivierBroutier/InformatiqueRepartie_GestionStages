import { Stage } from './stage.model';

export interface Professeur {
    id?: number;
    nomProf?: string;
    prenomProf?: string;
    login?: string;
    email?: string;
    stages?: Stage[];
}

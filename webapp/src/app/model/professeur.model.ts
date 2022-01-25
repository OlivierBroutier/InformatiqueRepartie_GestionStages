import { Stage } from './stage.model';
import { Message } from './message.model';

export interface Professeur {
    id?: number;
    nomProf?: string;
    prenomProf?: string;
    login?: string;
    mdp?: string;
    email?: string;
    stages?: Stage[];
    messagesEnvoyes?: Message[];
    messagesRecus?: Message[];
}

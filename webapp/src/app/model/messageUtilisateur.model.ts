import { MessageUtilisateurTypeEnum } from './message-utilisateur-type.enum';

export interface MessageUtilisateur {
    id? : number;
    nom? : string;
    prenom? : string;
    email? : string;
    lu? : string;
    messageUtilisateurType? : MessageUtilisateurTypeEnum;

}

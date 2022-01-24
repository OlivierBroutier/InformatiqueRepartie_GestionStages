import {MessageUtilisateur} from "./messageUtilisateur.model";

export interface Message {
   id? : number;
   expediteur? : MessageUtilisateur;
   destinataires? : MessageUtilisateur[];
   sujet? : string;
   message? : string;

}

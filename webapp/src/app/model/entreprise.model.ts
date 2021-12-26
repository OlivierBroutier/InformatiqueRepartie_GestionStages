import { Stage } from './stage.model';

export interface Entreprise {
    id?: number;
    raisonSociale? : string;
    nomContact? : string;
    nomResp? : string;
    rueEntreprise? : string;
    cpEntreprise? : string;
    villeEntreprise? : string;
    telEntreprise? : string;
    faxEntreprise? : string;
    email? : string;
    observation? : string;
    siteEntreprise? : string;
    niveau? : string;
    enActivite? : boolean;
    stages?: Stage[];
}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthGuard } from './shared/guard/auth.guard';
import { LoginComponent } from './login/login.component';
import { StageComponent } from './stage/stage.component';
import { EntrepriseComponent } from './entreprise/entreprise.component';
import {EntrepriseDetailComponent} from "./entreprise/entreprise-detail/entreprise-detail.component";
import {AjoutEntrepriseComponent} from "./entreprise/entreprise-ajout/ajout-entreprise.component";
import {InscriptionComponent} from "./inscription/inscription.component";
import {AideComponent} from "./aide/aide.component";
import {StagiaireComponent} from "./stagiaire/stagiaire.component";
import {StagiaireAjoutComponent} from "./stagiaire/stagiaire-ajout/stagiaire-ajout.component";
import {StagiaireDetailComponent} from "./stagiaire/stagiaire-detail/stagiaire-detail.component";
import {StageModifComponent} from "./stage/stage-modif/stage-modif.component";
import {StatistiquesComponent} from "./statistiques/statistiques.component";
import {ContactComponent} from "./contact/contact.component";
import {MessagerieComponent} from "./messagerie/messagerie.component";




const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'home' },
    { path: 'home', component: HomeComponent,canActivate : [AuthGuard]},
    { path: 'connexion', component: LoginComponent },
    { path: 'stage', children : [
            { path: '', pathMatch: 'full', component: StageComponent,canActivate : [AuthGuard] },
            { path: 'modif/:idStage', component: StageModifComponent,canActivate : [AuthGuard] }

    ]},
    { path: 'entreprise', children: [
            { path: '', pathMatch: 'full', component: EntrepriseComponent, canActivate : [AuthGuard]},
            { path: 'ajout', component: AjoutEntrepriseComponent, canActivate : [AuthGuard] },
            { path: ':idEntreprise', component: EntrepriseDetailComponent, canActivate : [AuthGuard] },

        ] },
    { path: 'inscription', component : InscriptionComponent, canActivate : [AuthGuard]},
    { path: 'aide', component : AideComponent, canActivate : [AuthGuard]},
    { path: 'stagiaire', children : [
            { path: '', pathMatch: 'full', component: StagiaireComponent, canActivate : [AuthGuard] },
            { path: 'ajout',  component: StagiaireAjoutComponent, canActivate : [AuthGuard] },
            { path: ':idStagiaire', component:StagiaireDetailComponent, canActivate : [AuthGuard]}

        ] },
    { path: 'statistiques', component : StatistiquesComponent, canActivate : [AuthGuard]},
    { path: 'contact', component : ContactComponent, canActivate : [AuthGuard]},
    { path: 'messagerie', component : MessagerieComponent, canActivate : [AuthGuard]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

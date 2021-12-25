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




const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: 'home' },
    { path: 'home', component: HomeComponent,canActivate : [AuthGuard]},
    { path: 'connexion', component: LoginComponent },
    { path: 'stage', component: StageComponent },
    { path: 'entreprise', children: [
            { path: '', pathMatch: 'full', component: EntrepriseComponent },
            { path: 'ajout', component: AjoutEntrepriseComponent },
            { path: ':idEntreprise', component: EntrepriseDetailComponent },

        ] },
    { path: 'inscription', component : InscriptionComponent},
    { path: 'aide', component : AideComponent},
    { path: 'stagiaire', component: StagiaireComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

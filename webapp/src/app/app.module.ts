import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AlertComponent } from './shared/component/alert/alert.component';
import { AuxAlertComponent } from './shared/component/alert/aux-alert/aux-alert.component';
import { AuxAlertErrorComponent } from './shared/component/alert/aux-alert/aux-alert-error/aux-alert-error.component';
import { HttpDefaultInterceptor } from './shared/inteceptor/http-default.interceptor';
import { StageComponent } from './stage/stage.component';
import { EntrepriseComponent } from './entreprise/entreprise.component';
import { EntrepriseDetailComponent } from './entreprise/entreprise-detail/entreprise-detail.component';
import { AjoutEntrepriseComponent } from './entreprise/entreprise-ajout/ajout-entreprise.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { AideComponent } from './aide/aide.component';
import { AuxAlertSuccessComponent } from './shared/component/alert/aux-alert/aux-alert-success/aux-alert-success.component';
import { StagiaireComponent } from './stagiaire/stagiaire.component';
import { StagiaireAjoutComponent } from './stagiaire/stagiaire-ajout/stagiaire-ajout.component';
import { StagiaireDetailComponent } from './stagiaire/stagiaire-detail/stagiaire-detail.component';
import { StageModifComponent } from './stage/stage-modif/stage-modif.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { StatistiquesComponent } from './statistiques/statistiques.component';
import { TelFormatterDirective } from './shared/directory/tel-formatter.directive';
import {ChartsModule, MDBBootstrapModule, MDBRootModule} from "angular-bootstrap-md";
import { NgSelectModule } from '@ng-select/ng-select';
import { MissionsComponent } from './entreprise/entreprise-ajout/missions/missions.component';
import { ConfirmationPopupComponent } from './confirmation-popup/confirmation-popup.component';
import { ContactComponent } from './contact/contact.component';
import { MessagerieComponent } from './messagerie/messagerie.component';
import { MessagePopupComponent } from './message-popup/message-popup.component';


@NgModule({
    declarations: [
        AppComponent,
        MenuComponent,
        LoginComponent,
        HomeComponent,
        AlertComponent,
        AuxAlertComponent,
        AuxAlertSuccessComponent,
        AuxAlertErrorComponent,
        StageComponent,
        EntrepriseComponent,
        EntrepriseDetailComponent,
        AjoutEntrepriseComponent,
        InscriptionComponent,
        AideComponent,
        StagiaireComponent,
        StagiaireAjoutComponent,
        StagiaireDetailComponent,
        StageModifComponent,
        StatistiquesComponent,
        TelFormatterDirective,
        MissionsComponent,
        ConfirmationPopupComponent,
        ContactComponent,
        MessagerieComponent,
        MessagePopupComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        NgbModule,
        ChartsModule,
        MDBRootModule,
        MDBBootstrapModule.forRoot(),
        NgSelectModule
    ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: HttpDefaultInterceptor, multi: true },
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }

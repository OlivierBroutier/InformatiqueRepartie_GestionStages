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

@NgModule({
    declarations: [
        AppComponent,
        MenuComponent,
        LoginComponent,
        HomeComponent,
        AlertComponent,
        AuxAlertComponent,
        AuxAlertErrorComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: HttpDefaultInterceptor, multi: true },
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }

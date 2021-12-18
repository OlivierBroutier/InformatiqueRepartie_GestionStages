import { Component, OnInit } from '@angular/core';
import { Login } from '../model/login.model';
import { AuthentificationService } from '../shared/authentification.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    public loginForm: Login = { statut: 'E' };

    constructor(
        private authentificationService: AuthentificationService,
        private activatedRoute: ActivatedRoute,
        private router: Router
    ) { }

    ngOnInit(): void {
    }

    public async login(): Promise<void> {
        await this.authentificationService.login(this.loginForm);
        if (this.authentificationService.isLoggedIn) {
            const url = this.activatedRoute.snapshot.queryParamMap.get('url');
            if (url) {
                this.router.navigate([url]);
            } else {
                this.router.navigate(['/home']);
            }
        }
    }

}

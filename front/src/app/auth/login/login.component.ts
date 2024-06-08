import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/auth/login.service';
import { LoginRequest } from 'src/app/services/auth/loginRequest';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  loginError: string = '';

  constructor(
    private formBuilder: FormBuilder,
    private loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  login() {
    if (this.loginForm.invalid) {
      this.loginError = 'Por favor, completa todos los campos correctamente.';
      return;
    }

    const credentials: LoginRequest = this.loginForm.value;

    this.loginService.login(credentials).subscribe(
      user => {
        if (user) {
          this.router.navigate(['/home']);
        } else {
          this.loginError = 'Credenciales incorrectas';
        }
      },
      error => {
        this.loginError = 'Error durante el inicio de sesión';
      }
    );
  }

  get f() {
    return this.loginForm.controls;
  }
}

import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RegisterService } from 'src/app/services/auth/register.service';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerError: string = '';
  

  constructor(private registerService: RegisterService,private router: Router) { }
  

  register(registerForm: NgForm): void {
    if (registerForm.valid) {
      const newUser: User = {
        nombre: registerForm.value.name,
        apellidos: registerForm.value.apellidos, 
        contrasena: registerForm.value.password,
        direccion: registerForm.value.direccion, 
        email: registerForm.value.email,
        rol:registerForm.value.role
      };

      this.registerService.register(newUser).subscribe(
        () => {
          console.log('Registro exitoso');
          this.router.navigate(['/home']);// Puedes redirigir al usuario a otra página o mostrar un mensaje de éxito aquí
        },
        error => {
          console.error('Error durante el registro:', error);
          this.registerError = 'Error durante el registro. Por favor, inténtalo de nuevo.';
        }
      );
    }
  }
}


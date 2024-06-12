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

  constructor(private registerService: RegisterService, private router: Router) { }

  register(registerForm: NgForm): void {
    if (registerForm.valid) {
      const isAdmin = registerForm.value.isAdmin;  // Obtener el valor del checkbox
      const role = isAdmin ? 'admin' : 'user';  // Determinar el rol basado en el checkbox

      const newUser: User = {
        nombre: registerForm.value.name,
        apellidos: registerForm.value.apellidos,
        contrasena: registerForm.value.password,
        direccion: registerForm.value.direccion,
        email: registerForm.value.email,
        rol: role  // Usar el rol determinado
      };

      this.registerService.register(newUser).subscribe(
        () => {
          console.log('Registro exitoso');
          this.router.navigate(['/home']);  // Redirigir al usuario después del registro exitoso
        },
        error => {
          console.error('Error durante el registro:', error);
          this.registerError = 'Error durante el registro. Por favor, inténtalo de nuevo.';
        }
      );
    }
  }
}

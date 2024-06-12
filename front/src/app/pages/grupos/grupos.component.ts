import { Component, OnInit } from '@angular/core';
import { GruposService } from 'src/app/services/auth/grupo.service';
import { Grupo } from '../../models/grupo';
import { LoginService } from 'src/app/services/auth/login.service';

@Component({
  selector: 'app-grupos',
  templateUrl: './grupos.component.html',
  styleUrls: ['./grupos.component.css']
})
export class GruposComponent implements OnInit {
  grupos: Grupo[] = [];
  isCreating: boolean = false;
  newGrupo: Grupo = {
    id_grupo: NaN,
    nombre_grupo: '',
    num_participantes: NaN,
    
  };

  constructor(private gruposService: GruposService, public loginService: LoginService) { }

  ngOnInit(): void {
    this.getGrupos();
  }

  getGrupos(): void {
    this.gruposService.getGrupos()
      .subscribe(grupos => this.grupos = grupos);
  }

  crearGrupo(): void {
    this.isCreating = true;
  }

  submitGrupo(): void {
    this.gruposService.createGrupo(this.newGrupo).subscribe({
      next: (data) => {
        console.log('Grupo creado:', data);
        this.grupos.push(data);
        this.isCreating = false; // Ocultar el formulario después de crearlo
        this.newGrupo = {
          id_grupo: NaN,
          nombre_grupo: '',
          num_participantes: NaN,
        }; // Restablecer el formulario
      },
      error: (error) => console.error('Error al crear el grupo:', error)
    });
  }

  cancelCreateGrupo(): void {
    this.isCreating = false;
  }
}

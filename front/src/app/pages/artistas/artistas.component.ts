import { Component, OnInit } from '@angular/core';
import { ArtistasService } from 'src/app/services/auth/artista.service'; // Asegúrate de tener un servicio para Artistas
import { Artista } from '../../models/artista'; // Cambia el path si es necesario
import { LoginService } from 'src/app/services/auth/login.service';

@Component({
  selector: 'app-artistas',
  templateUrl: './artistas.component.html',
  styleUrls: ['./artistas.component.css']
})
export class ArtistasComponent implements OnInit {
  artistas: Artista[] = [];
  isCreating: boolean = false;
  newArtista: Artista = {
    id_artista: NaN,
    nombre: '',
    genero_musical: '',
    descripcion: ''
  };

  constructor(private artistasService: ArtistasService, public loginService: LoginService) { }

  ngOnInit(): void {
    this.getArtistas();
  }

  getArtistas(): void {
    this.artistasService.getArtistas()
      .subscribe(artistas => this.artistas = artistas);
  }

  crearArtista(): void {
    console.log('Crear Artista llamado');
    this.isCreating = true;
  }

  submitArtista(): void {
    this.artistasService.createArtista(this.newArtista).subscribe({
      next: (data) => {
        console.log('Artista creado:', data);
        this.artistas.push(data);
        this.isCreating = false; // Ocultar el formulario después de crear
        this.newArtista = {
          id_artista: NaN,
          nombre: '',
          genero_musical: '',
          descripcion: ''
        }; // Reiniciar el formulario
      },
      error: (error) => console.error('Error al crear el artista:', error)
    });
  }

 
  
  cancelCreateArtista(): void {
    console.log('Cancelar Creación Artista llamado');
    this.isCreating = false;
  }
}

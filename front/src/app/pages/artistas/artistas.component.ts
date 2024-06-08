// src/app/pages/artistas/artistas.component.ts
import { Component, OnInit } from '@angular/core';
import { ArtistasService } from 'src/app/services/auth/artista.service';
import { Artista } from '../../models/artista';
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
    id_artista:NaN,
    nombre: '',
    genero_musical: '',
    descripcion: ''
   
  };

  constructor(private artistasService: ArtistasService,public loginservice:LoginService) {}

  ngOnInit(): void {
    this.artistasService.getArtistas().subscribe(artistas => this.artistas = artistas);
  }
  crearArtista(): void {
    this.isCreating = true;
  }

  submitArtista(): void {
    
  }

  cancelCreateArtista(): void {
    this.isCreating = false;
  }
}

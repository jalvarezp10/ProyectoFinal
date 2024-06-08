
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArtistasService } from 'src/app/services/auth/artista.service';
import { Artista } from '../../models/artista';
import { YouTubeService } from 'src/app/services/auth/youtube.service';


@Component({
  selector: 'app-artista-detail',
  templateUrl: './artista-detail.component.html',
  styleUrls: ['./artista-detail.component.css']
})
export class ArtistaDetailComponent implements OnInit {
  artista: any;
  videoUrl: string | undefined;
  isEditing: boolean = false;
  updatedArtista: Partial<Artista> = {};
  

  constructor(
    private route: ActivatedRoute,
    private artistaService: ArtistasService,
    private youTubeService: YouTubeService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getArtista();
  }

  getArtista(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.artistaService.getArtista(id).subscribe(artista => {
      this.artista = artista;
      this.getArtistaVideo(artista.nombre);
    });
  }

  getArtistaVideo(query: string): void {
    this.youTubeService.searchVideos(query + ' song').subscribe(response => {
      if (response.items.length > 0) {
        const videoId = response.items[0].id.videoId;
        this.videoUrl = `https://www.youtube.com/embed/${videoId}`;
      }
    });
  }
  startEditing(): void {
    this.isEditing = true;
    // Prellenar los campos del formulario con los valores actuales del festival
    this.updatedArtista = { ...this.artista };
  }

  saveChanges(): void {
    // Mantener los valores actuales si los campos están vacíos
    const updatedData: Artista = {
      ...this.artista,
      ...this.updatedArtista
    };

    this.artistaService.updateArtista(updatedData).subscribe(() => {
      this.isEditing = false;
      this.getArtista(); // Actualizar los datos del festival después de la edición
    });
  }

  deleteArtista(): void {
    if (confirm('¿Está seguro de que desea eliminar este festival?')) {
      this.artistaService.deleteArtista(this.artista.id_artista).subscribe(() => {
        this.router.navigate(['/festivales']);
      });
    }
  }

  isAdmin(): boolean {
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    return user.rol === 'admin';
  }
}

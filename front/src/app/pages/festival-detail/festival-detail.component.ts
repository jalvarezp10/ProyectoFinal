import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FestivalesService } from 'src/app/services/auth/festivales.service';
import { Festival } from '../../models/festivales';
import { YouTubeService } from 'src/app/services/auth/youtube.service';
import { LoginService } from 'src/app/services/auth/login.service';


@Component({
  selector: 'app-festival-detail',
  templateUrl: './festival-detail.component.html',
  styleUrls: ['./festival-detail.component.css']
})
export class FestivalDetailComponent implements OnInit {
  festival: any;
  videoUrl: string = '';
  isEditing: boolean = false;
  updatedFestival: Partial<Festival> = {};

  constructor(
    private route: ActivatedRoute,
    private festivalService: FestivalesService,
    private youTubeService: YouTubeService,
    public loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getFestival();
  }

  getFestival(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.festivalService.getFestival(id).subscribe(festival => {
      this.festival = festival;
      this.getFestivalVideo(festival.nombre);
    });
  }

  getFestivalVideo(query: string): void {
    this.youTubeService.searchVideos(query).subscribe((response: any) => {
      if (response.items.length > 0) {
        const videoId = response.items[0].id.videoId;
        this.videoUrl = `https://www.youtube.com/embed/${videoId}`;
      }
    });
  }

  startEditing(): void {
    this.isEditing = true;
    // Prellenar los campos del formulario con los valores actuales del festival
    this.updatedFestival = { ...this.festival };
  }

  saveChanges(): void {
    // Mantener los valores actuales si los campos están vacíos
    const updatedData: Festival = {
      ...this.festival,
      ...this.updatedFestival
    };

    this.festivalService.updateFestival(updatedData).subscribe(() => {
      this.isEditing = false;
      this.getFestival(); // Actualizar los datos del festival después de la edición
    });
  }

  deleteFestival(): void {
    if (confirm('¿Está seguro de que desea eliminar este festival?')) {
      this.festivalService.deleteFestival(this.festival.id_festival).subscribe(() => {
        this.router.navigate(['/festivales']);
      });
    }
  }

  isAdmin(): boolean {
    const user = JSON.parse(localStorage.getItem('user') || '{}');
    return user.rol === 'admin';
  }
  
 

  
  
  
}

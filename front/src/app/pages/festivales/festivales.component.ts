import { Component, OnInit } from '@angular/core';
import { FestivalesService } from 'src/app/services/auth/festivales.service';
import { Festival } from '../../models/festivales';
import { LoginService } from 'src/app/services/auth/login.service';

@Component({
  selector: 'app-festivales',
  templateUrl: './festivales.component.html',
  styleUrls: ['./festivales.component.css']
})
export class FestivalesComponent implements OnInit {
  festivales: Festival[] = [];
  isCreating: boolean = false;
  newFestival: Festival = {
    id_festival:NaN,
    nombre: '',
    fecha_inicio: new Date(),
    fecha_finalizacion: new Date(),
    ubicacion: '',
    descripcion: ''
  };

  constructor(private festivalesService: FestivalesService,public loginService: LoginService) { }

  ngOnInit(): void {
    this.getFestivales();
  }

  getFestivales(): void {
    this.festivalesService.getFestivales()
      .subscribe(festivales => this.festivales = festivales);
  }
  crearFestival(): void {
    this.isCreating = true;
  }

  submitFestival(): void {
    this.festivalesService.createFestival(this.newFestival).subscribe({
      next: (data) => {
        console.log('Festival creado:', data);
        this.festivales.push(data);
        this.isCreating = false; 
        this.newFestival = {
          id_festival:NaN,
          nombre: '',
          fecha_inicio: new Date(),
          fecha_finalizacion: new Date(),
          ubicacion: '',
          descripcion: ''
        }; 
      },
      error: (error) => console.error('Error al crear el festival:', error)
    });
  }

  cancelCreateFestival(): void {
    this.isCreating = false;
  }

}

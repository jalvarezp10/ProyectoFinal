// src/app/services/artistas.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Artista } from 'src/app/models/artista';

@Injectable({
  providedIn: 'root'
})
export class ArtistasService {
  private apiUrl = 'https://proyectofinal-3qyo.onrender.com/api/v1/artistas';

  constructor(private http: HttpClient) {}

  getArtistas(): Observable<Artista[]> {
    return this.http.get<Artista[]>(this.apiUrl);
  }

  getArtista(id: number): Observable<Artista> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Artista>(url);
  }
  createArtista(artista: Artista): Observable<Artista> {
    return this.http.post<Artista>(this.apiUrl, artista).pipe(
      catchError(this.handleError)
    );
  }
  updateArtista(artista: Artista): Observable<any> {
    const url = `${this.apiUrl}/${artista.id_artista}`;
    return this.http.put(url, artista).pipe(
      catchError(this.handleError)
    );
  }
  deleteArtista(id: number): Observable<any> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.delete(url).pipe(
      catchError(this.handleError)
    );
  }
  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('Se ha producido un error:', error.error);
    } else {
      console.error('Backend retornó el código de estado:', error.status, error.error);
    }
    return throwError(() => new Error('Algo falló. Por favor intente nuevamente.'));
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Grupo } from '../../models/grupo';

@Injectable({
  providedIn: 'root'
})
export class GruposService {
  private apiUrl = 'https://proyectofinal-3qyo.onrender.com/api/v1/grupos';

  constructor(private http: HttpClient) { }

  getGrupos(): Observable<Grupo[]> {
    return this.http.get<Grupo[]>(this.apiUrl);
  }

  getGrupo(id: number): Observable<Grupo> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Grupo>(url);
  }

  createGrupo(grupo: Grupo): Observable<Grupo> {
    return this.http.post<Grupo>(this.apiUrl, grupo).pipe(
      catchError(this.handleError)
    );
  }

  updateGrupo(grupo: Grupo): Observable<any> {
    const url = `${this.apiUrl}/${grupo.id_grupo}`;
    return this.http.put(url, grupo).pipe(
      catchError(this.handleError)
    );
  }

  deleteGrupo(id: number): Observable<any> {
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

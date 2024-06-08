import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Festival } from '../../models/festivales';



@Injectable({
  providedIn: 'root'
})
export class FestivalesService {
  private apiUrl = 'http://localhost:8080/api/v1/festivales';

  constructor(private http: HttpClient) { }

  getFestivales(): Observable<Festival[]> {
    return this.http.get<Festival[]>(this.apiUrl);
  }

  getFestival(id: number): Observable<Festival> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<Festival>(url);
  }
  createFestival(festival: Festival): Observable<Festival> {
    return this.http.post<Festival>(this.apiUrl, festival).pipe(
      catchError(this.handleError)
    );
  }

  updateFestival(festival: Festival): Observable<any> {
    const url = `${this.apiUrl}/${festival.id_festival}`;
    return this.http.put(url, festival).pipe(
      catchError(this.handleError)
    );
  }

  deleteFestival(id: number): Observable<any> {
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

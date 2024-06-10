import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginRequest } from './loginRequest';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { User } from '../../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  currentUserLoginOn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);
  currentUserData: BehaviorSubject<User> = new BehaviorSubject<User>({ email: '', contrasena: '', direccion: '', nombre: '', apellidos: '', rol: '' });

  constructor(private http: HttpClient) {
    this.loadUserFromLocalStorage();  // Cargar usuario desde localStorage al inicializar el servicio
  }

  public loginUrl = 'https://proyectofinal-3qyo.onrender.com/api/v1/usuarios';

  login(credentials: LoginRequest): Observable<User | null> {
    return this.http.get<User[]>(this.loginUrl).pipe(
      map((users: User[]) => {
        const user = users.find(
          u => u.email === credentials.email && u.contrasena === credentials.password
        );
        if (user) {
          this.currentUserData.next(user);
          this.currentUserLoginOn.next(true);
          localStorage.setItem('user', JSON.stringify(user));
          return user;
        } else {
          return null;
        }
      }),
      catchError(this.handleError)
    );
  }

  logout(): void {
    this.currentUserData.next({ email: '', contrasena: '', direccion: '', nombre: '', apellidos: '', rol: '' });
    this.currentUserLoginOn.next(false);
    localStorage.removeItem('user');
  }

  isAuthenticated(): boolean {
    return localStorage.getItem('user') !== null;
  }

  private loadUserFromLocalStorage(): void {
    const user = localStorage.getItem('user');
    if (user) {
      const parsedUser: User = JSON.parse(user);
      this.currentUserData.next(parsedUser);
      this.currentUserLoginOn.next(true);
    }
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      console.error('Se ha producido un error:', error.error);
    } else {
      console.error('Backend retornó el código de estado:', error.status, error.error);
    }
    return throwError(() => new Error('Algo falló. Por favor intente nuevamente.'));
  }

  get userData(): Observable<User> {
    return this.currentUserData.asObservable();
  }

  get userLoginOn(): Observable<boolean> {
    return this.currentUserLoginOn.asObservable();
  }
}

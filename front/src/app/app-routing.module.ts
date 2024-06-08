import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { RegisterComponent } from './auth/register/register.component';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import { FestivalesComponent } from './pages/festivales/festivales.component';
import { FestivalDetailComponent } from './pages/festival-detail/festival-detail.component';
import { GruposComponent } from './pages/grupos/grupos.component';
import { ArtistasComponent } from './pages/artistas/artistas.component';
import { ArtistaDetailComponent } from './pages/artista-detail/artista-detail.component';
import { AuthGuard } from './services/auth/auth.guards';


const routes: Routes = [
  { path: '', component: WelcomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'festivales', component: FestivalesComponent },
  { path: 'festivales/:id', component: FestivalDetailComponent },
  { path: 'grupos', component: GruposComponent },
  { path: 'artistas', component: ArtistasComponent },
  { path: 'artistas/:id', component: ArtistaDetailComponent },
  { path: 'register', component: RegisterComponent },
  { path: '**', redirectTo: '' } // Redirección para rutas no encontradas
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

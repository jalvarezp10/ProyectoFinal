import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { NavComponent } from './shared/nav/nav.component';
import { HeaderComponent } from './shared/header/header.component'; // Ajusta la ruta según la ubicación real
import { FooterComponent } from './shared/footer/footer.component'; 
import { HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from './pages/welcome/welcome.component';
import { FestivalesComponent } from './pages/festivales/festivales.component';
import { ArtistasComponent } from './pages/artistas/artistas.component';
import { GruposComponent } from './pages/grupos/grupos.component';
import { FestivalDetailComponent } from './pages/festival-detail/festival-detail.component';
import { ArtistaDetailComponent } from './pages/artista-detail/artista-detail.component'; 
import { SafeUrlPipe } from './safe-url.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    NavComponent,
    HeaderComponent,
    FooterComponent,
    WelcomeComponent,
    FestivalesComponent,
    ArtistasComponent,
    GruposComponent,
    FestivalDetailComponent,
    ArtistaDetailComponent,
    SafeUrlPipe,
    
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

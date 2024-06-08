package com.festivapp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.festivapp.modelo.Artista;
import com.festivapp.modelo.Festival;
import com.festivapp.repositorio.ArtistaRepositorio;
import com.festivapp.repositorio.FestivalRepositorio;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaServicio {

    @Autowired
    private ArtistaRepositorio artistaRepositorio;

    public List<Artista> obtenerTodosLosArtista() {
        return artistaRepositorio.findAll();
    }
    
    public Artista createArtista(Artista artista) {
        return artistaRepositorio.save(artista);
    }

    public Optional<Artista> obtenerArtistaPorId(Long id) {
        return artistaRepositorio.findById(id);
    }
    public Artista updateArtista(Artista artista) {
        return artistaRepositorio.save(artista);
    }
    public void deleteArtista(Long id) {
    	artistaRepositorio.deleteById(id);
    }

    
}

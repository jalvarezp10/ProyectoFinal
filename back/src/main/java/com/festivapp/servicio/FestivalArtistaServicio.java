package com.festivapp.servicio;


import com.festivapp.modelo.FestivalArtista;
import com.festivapp.repositorio.FestivalArtistaRepositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FestivalArtistaServicio {

    @Autowired
    private FestivalArtistaRepositorio festivalArtistaRepositorio;

    public List<FestivalArtista> getAllFestivalArtistas() {
        return festivalArtistaRepositorio.findAll();
    }

    public Optional<FestivalArtista> getFestivalArtistasByFestivalId(Long festivalId) {
        return festivalArtistaRepositorio.findById(festivalId);
    }

    public FestivalArtista createFestivalArtista(FestivalArtista festivalArtista) {
        return festivalArtistaRepositorio.save(festivalArtista);
    }

    public void deleteFestivalArtista(Long id) {
    	festivalArtistaRepositorio.deleteById(id);
    }

    public void deleteFestivalArtistasByFestivalId(Long festivalId) {
    	festivalArtistaRepositorio.deleteById(festivalId);
    }
}

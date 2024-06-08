package com.festivapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festivapp.modelo.FestivalArtista;



@Repository
public interface FestivalArtistaRepositorio extends JpaRepository<FestivalArtista, Long> {
}

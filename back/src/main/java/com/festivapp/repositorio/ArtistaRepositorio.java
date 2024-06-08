package com.festivapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festivapp.modelo.Artista;


@Repository
public interface ArtistaRepositorio extends JpaRepository<Artista, Long> {
}

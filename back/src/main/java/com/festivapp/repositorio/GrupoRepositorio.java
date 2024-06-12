package com.festivapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.festivapp.modelo.Grupo;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo, Long> {
}

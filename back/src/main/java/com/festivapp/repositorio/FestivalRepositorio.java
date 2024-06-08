package com.festivapp.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festivapp.modelo.Festival;



@Repository
public interface FestivalRepositorio extends JpaRepository<Festival, Long> {
}

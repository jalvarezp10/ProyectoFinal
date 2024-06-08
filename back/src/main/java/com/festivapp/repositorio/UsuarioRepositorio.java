package com.festivapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.festivapp.modelo.Usuario;



@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findByContrasena(String contrasena);

	Usuario findByEmail(String email);

}
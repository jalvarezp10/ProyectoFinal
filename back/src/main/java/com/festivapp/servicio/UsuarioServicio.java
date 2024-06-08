package com.festivapp.servicio;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.festivapp.modelo.Usuario;
import com.festivapp.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepository;
    
    public List<Usuario> listarTodosUsuarios() {
		return usuarioRepository.findAll();
	}

    public Usuario createUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario authenticateUser(String contrasena, String password) {
        Usuario usuario = usuarioRepository.findByContrasena(contrasena);
        if (usuario != null && usuario.getContrasena().equals(password)) {
            return usuario;
        }
        return null;
    }

    public Usuario findUserByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
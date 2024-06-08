package com.festivapp.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 50, nullable = false)
    private String apellidos;

    @Column(name = "contrasena", length = 255, nullable = false, unique = true)
    private String contrasena;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "email", length = 100, nullable = false)
    private String email;
    
    @Column(name = "rol", length = 100, nullable = false)
    private String rol;

    public Usuario() {

    }

    public Usuario(Long id_user, String nombre, String apellidos, String contrasena, String direccion, String email, String rol) {
        super();
        this.id_user = id_user;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.email = email;
        this.rol = rol;
        
    }

    public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

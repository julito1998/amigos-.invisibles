package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;

public class GrupoCreargrupoDTO implements Serializable {

    private String nombre;
    private String email;

    public GrupoCreargrupoDTO() {
        super();
    }

    public GrupoCreargrupoDTO(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
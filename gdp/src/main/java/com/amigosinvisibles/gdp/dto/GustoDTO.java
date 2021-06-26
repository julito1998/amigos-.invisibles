package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;

public class GustoDTO implements Serializable {
    private String nombre;
    private String codigo;

    public GustoDTO(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public GustoDTO(){
        super();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;
import java.util.List;

public class UserPerfilDTO implements Serializable {
    private int cantidadGruposPertenece;
    private int cantidadGruposAdministra;
    private String firstName;
    private String lastName;
    private List<GustoDTO> gustos;

    public UserPerfilDTO(int cantidadGruposPertenece, int cantidadGruposAdministra, String firstName, String lastName, List<GustoDTO> gustos) {
        this.cantidadGruposPertenece = cantidadGruposPertenece;
        this.cantidadGruposAdministra = cantidadGruposAdministra;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gustos = gustos;
    }

    public UserPerfilDTO() {
    }

    public int getCantidadGruposPertenece() {
        return cantidadGruposPertenece;
    }

    public void setCantidadGruposPertenece(int cantidadGruposPertenece) {
        this.cantidadGruposPertenece = cantidadGruposPertenece;
    }

    public int getCantidadGruposAdministra() {
        return cantidadGruposAdministra;
    }

    public void setCantidadGruposAdministra(int cantidadGruposAdministra) {
        this.cantidadGruposAdministra = cantidadGruposAdministra;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<GustoDTO> getGustos() {
        return gustos;
    }

    public void setGustos(List<GustoDTO> gustos) {
        this.gustos = gustos;
    }
}

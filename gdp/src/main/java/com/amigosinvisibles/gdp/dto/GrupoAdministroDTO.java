package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;
import java.util.Date;

public class GrupoAdministroDTO implements Serializable {
    private Long id;
    private String nombre;
    private Date fechaDelSorteo;
    private Date fechaLimite;
    private int participantesActuales;
    private boolean isActivo;

    public GrupoAdministroDTO() { super(); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaDelSorteo() {
        return fechaDelSorteo;
    }

    public void setFechaDelSorteo(Date fechaDelSorteo) {
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getParticipantesActuales() {
        return participantesActuales;
    }

    public void setParticipantesActuales(int participantesActuales) {
        this.participantesActuales = participantesActuales;
    }

    public boolean isActivo() {
        return isActivo;
    }

    public void setActivo(boolean activo) {
        isActivo = activo;
    }
}

package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;
import java.util.Date;

public class GrupoAdministroDTO implements Serializable {

    private String nombre;
    private Date fechaDelSorteo;
    private Date fechaLimite;
    private int participantesActuales;

    public GrupoAdministroDTO() { super(); }

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
}

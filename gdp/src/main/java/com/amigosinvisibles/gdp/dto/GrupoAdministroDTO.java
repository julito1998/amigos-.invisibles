package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GrupoAdministroDTO implements Serializable {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");
    private Long id;
    private String nombre;
    private String fechaDelSorteo;
    private String fechaLimite;
    private int participantesActuales;
    private boolean isActivo;

    public GrupoAdministroDTO() {
        super();
    }

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

    public String getFechaDelSorteo() {
        return fechaDelSorteo;
    }

    public void setFechaDelSorteo(String fechaDelSorteo) {
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
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

    public Date getFechaLimiteDateConverted() throws ParseException {
        return dateFormat.parse(this.fechaLimite);
    }

    public void setFechaLimiteInDate(Date date) {
        this.fechaLimite = dateFormat.format(date);
    }

    public Date getFechaDelSorteoDateConverted() throws ParseException {
        return dateFormat.parse(this.fechaDelSorteo);
    }

    public void setFechaDelSorteoInDate(Date date) {
        this.fechaDelSorteo = dateFormat.format(date);
    }
}

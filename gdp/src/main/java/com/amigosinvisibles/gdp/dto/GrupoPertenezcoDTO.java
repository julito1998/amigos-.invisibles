package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;
import java.util.Date;

public class GrupoPertenezcoDTO implements Serializable {

    private String nombre;
    private Date fechaDelSorteo;
    private Date fechaLimite;
    private String amigoInvisible;
    private String eMail;

    public GrupoPertenezcoDTO(String nombre, Date fechaDelSorteo, Date fechaLimite, String amigoInvisible, String eMail){
        super();
        this.nombre = nombre;
        this.fechaDelSorteo = fechaDelSorteo;
        this.fechaLimite = fechaLimite;
        this.amigoInvisible = amigoInvisible;
        this.eMail = eMail;
    }

    public GrupoPertenezcoDTO(){
        super();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setFechaDelSorteo(Date fechaDelSorteo){
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public Date getFechaDelSorteo(Date fechaDelSorteo){
        return fechaDelSorteo;
    }

    public void setFechaLimite(Date fechaLimite){
        this.fechaLimite = fechaLimite;
    }

    public Date getFechaLimite(Date fechaLimite){
        return fechaLimite;
    }

    public void setAmigoInvisible(String amigoInvisible){
        this.amigoInvisible = amigoInvisible;
    }

    public String getAmigoInvisible(){
        return amigoInvisible;
    }

    public void setEMail(String eMail){
        this.eMail = eMail;
    }

    public String getEMail(){
        return eMail;
    }
}

package com.amigosinvisibles.gdp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GrupoPertenezcoDTO implements Serializable {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");

    private String nombre;
    private String fechaDelSorteo;
    private String fechaLimite;
    private String amigoInvisible;
    private String eMail;

    public GrupoPertenezcoDTO(String nombre, String fechaDelSorteo, String fechaLimite, String amigoInvisible, String eMail){
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

    public void setFechaDelSorteo(String fechaDelSorteo){
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public String getFechaDelSorteo(){
        return this.fechaDelSorteo;
    }

    public void setFechaLimite(String fechaLimite){
        this.fechaLimite = fechaLimite;
    }

    public String getFechaLimite(){
        return this.fechaLimite;
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

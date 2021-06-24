package com.amigosinvisibles.gdp.model;

import javax.persistence.*;
import java.util.Date;

//esta tabla no puede ser modicada por los usuarios, es solo de consulta de datos
// para llenar un combo box en la vista
// y por si el dia de mañana surgen mas formas de realizar el sorteo
// ID=1 fechaDelSorteo
// ID=2 capacidadMaxima
// ID=3 decisionDelAdmin

@Entity
@Table(name = "tipo_sorteo")
public class TipoSorteo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TIPOS DE SORTEO
    //fecha que se elije para realizar el sorteo por el admin
    @Column(name="fecha_sorteo")
    private Date fechaDelSorteo;

    //capacidad maxima que se elije el sorteo para realizar el sorteo
    @Column(name="capacidad_maxima")
    private int capacidadMaxima;

    @Column(name = "decision_del_admin")
    private boolean decisionDelAdmin;

    public TipoSorteo(){
        super();
    }

    public TipoSorteo(Long id, Date fechaDelSorteo, int capacidadMaxima, boolean decisionDelAdmin) {
        this.id = id;
        this.fechaDelSorteo = fechaDelSorteo;
        this.capacidadMaxima = capacidadMaxima;
        this.decisionDelAdmin = decisionDelAdmin;
    }


    public TipoSorteo(boolean decisionDelAdmin) {
        this.decisionDelAdmin = decisionDelAdmin;
    }

    public TipoSorteo(Date fechaDelSorteo) {
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public TipoSorteo(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public Date getFechaDelSorteo() {
        return fechaDelSorteo;
    }

    public void setFechaDelSorteo(Date fechaDelSorteo) {
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public boolean isDecisionDelAdmin() {
        return decisionDelAdmin;
    }

    public void setDecisionDelAdmin(boolean decisionDelAdmin) {
        this.decisionDelAdmin = decisionDelAdmin;
    }

}

package com.amigosinvisibles.gdp.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "grupos")
public class Grupo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        @Column(unique = true)
        private String codigo;

        private String estado;
        //es la fecha limite que establecimos nosotros para realizar el sorteo y que los grupos no queden en estado 'PENDIENTE'
        @Column(name="fecha_limite_fija_de_grupo")
        private Date fechaLimite;

        //TIPOS DE SORTEO
        //fecha que se elije para realizar el sorteo por el admin
        @Column(name="fecha_sorteo")
        private Date fechaDelSorteo;

        //capacidad maxima que se elije el sorteo para realizar el sorteo
        @Column(name="capacidad_maxima")
        private int capacidadMaxima;

        @Column(name = "decision_del_admin")
        private boolean decisionDelAdmin;

        public Grupo() {
            super();
        }

    public Grupo(String nombre, String codigo, String estado, Date fechaLimite, Date fechaDelSorteo, int capacidadMaxima, boolean decisionDelAdmin) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.fechaDelSorteo = fechaDelSorteo;
        this.capacidadMaxima = capacidadMaxima;
        this.decisionDelAdmin = decisionDelAdmin;
    }

    public Grupo(String nombre, String codigo, String estado, Date fechaLimite, boolean decisionDelAdmin) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.decisionDelAdmin = decisionDelAdmin;
    }

    public Grupo(String nombre, String codigo, String estado, Date fechaLimite, int capacidadMaxima) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.capacidadMaxima = capacidadMaxima;
    }

    public Grupo(String nombre, String codigo, String estado, Date fechaLimite, Date fechaDelSorteo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
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

    public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
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

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
}

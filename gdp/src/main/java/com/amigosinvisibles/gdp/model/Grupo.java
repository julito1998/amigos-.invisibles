package com.amigosinvisibles.gdp.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.jws.Oneway;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "grupos", uniqueConstraints=@UniqueConstraint(name = "fk_tipo_sorteo_grupo",columnNames = {"id_tipo_sorteo", "id"}))
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_tipo_sorteo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private TipoSorteo tipoSorteo;

    private String nombre;

    @Column(unique = true)
    private String codigo;

    //NO ESTA DEFINIDO NINGUN CONSTRUCTOR
    @Column(name="participantes_actuales")
    private int participantesActuales;

    //capacidad maxima del grupo
    @Column(name="capacidad_maxima")
    private Integer capacidadMaxima;

    private String estado;
    //es la fecha limite que establecimos nosotros para realizar el sorteo y que los grupos no queden en estado 'PENDIENTE'
    @Column(name="fecha_limite_fija_de_grupo")
    private Date fechaLimite;

    public Grupo() {
            super();
        }

    public Grupo(Long id, TipoSorteo tipoSorteo, String nombre, String codigo, String estado, Date fechaLimite,Integer capacidadMaxima) {
        this.id = id;
        this.tipoSorteo = tipoSorteo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.capacidadMaxima=capacidadMaxima;
    }

    public Grupo(TipoSorteo tipoSorteo, String nombre, String codigo, String estado, Date fechaLimite,Integer capacidadMaxima) {
        this.tipoSorteo = tipoSorteo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.fechaLimite = fechaLimite;
        this.capacidadMaxima=capacidadMaxima;
    }

    public int getParticipantesActuales() {
        return participantesActuales;
    }

    public void setParticipantesActuales(int participantesActuales) {
        this.participantesActuales = participantesActuales;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public TipoSorteo getTipoSorteo() {
        return tipoSorteo;
    }

    public void setTipoSorteo(TipoSorteo tipoSorteo) {
        this.tipoSorteo = tipoSorteo;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
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

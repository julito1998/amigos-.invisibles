package com.amigosinvisibles.gdp.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sorteo_asignacion")
public class SorteoAsignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_user_visible", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User usuario_visible;

    @JoinColumn(name = "id_user_invisible", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User usuario_invisible;

    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Grupo grupo;

    @Column(name = "fecha_sorteo")
    @NotNull
    private Date fechaSorteo;

    public SorteoAsignacion(){
        super();
    }

    public SorteoAsignacion(Long id, User usuario_visible, User usuario_invisible, Grupo grupo, Date fechaSorteo) {
        this.id = id;
        this.usuario_visible = usuario_visible;
        this.usuario_invisible = usuario_invisible;
        this.grupo = grupo;
        this.fechaSorteo = fechaSorteo;
    }

    public SorteoAsignacion(User usuario_visible, User usuario_invisible, Grupo grupo, Date fechaSorteo) {
        this.usuario_visible = usuario_visible;
        this.usuario_invisible = usuario_invisible;
        this.grupo = grupo;
        this.fechaSorteo = fechaSorteo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario_visible() {
        return usuario_visible;
    }

    public void setUsuario_visible(User usuario_visible) {
        this.usuario_visible = usuario_visible;
    }

    public User getUsuario_invisible() {
        return usuario_invisible;
    }

    public void setUsuario_invisible(User usuario_invisible) {
        this.usuario_invisible = usuario_invisible;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Date getFechaSorteo() {
        return fechaSorteo;
    }

    public void setFechaSorteo(Date fechaSorteo) {
        this.fechaSorteo = fechaSorteo;
    }
}

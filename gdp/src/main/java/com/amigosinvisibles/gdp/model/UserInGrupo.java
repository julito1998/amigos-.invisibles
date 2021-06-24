package com.amigosinvisibles.gdp.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.amigosinvisibles.gdp.model.User;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_grupos", uniqueConstraints=@UniqueConstraint(name = "fk_user_grupo",columnNames = {"id_user", "id_grupo"}))
public class UserInGrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User usuario;

    @JoinColumn(name = "id_grupo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Grupo grupo;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public UserInGrupo(){
        super();
    }

    public UserInGrupo(User usuario, Grupo grupo, boolean isAdmin) {
        this.usuario = usuario;
        this.grupo = grupo;
        this.isAdmin = isAdmin;
    }

    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    public void setIsAmin(boolean isAdmin){
        this.isAdmin=isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

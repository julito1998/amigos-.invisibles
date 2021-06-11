package com.amigosinvisibles.gdp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String codigo;

    private int capacidad;

    @Column(name = "tipo_sorteo")
    private String tipoSorteo;

    @JoinTable(
            name = "grupos_users",
            joinColumns = @JoinColumn(name = "grupo_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="user_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> usuarios;

    public Grupo() {
        super();
    }

    public void addUsers(User user){
        if(this.usuarios == null){
            this.usuarios = new ArrayList<>();
        }
        this.usuarios.add(user);
    }

    public Grupo(Long id, String nombre, String codigo, int capacidad, String tipoSorteo, List<User> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.tipoSorteo = tipoSorteo;
        this.usuarios = usuarios;
    }

    public Grupo(String nombre, String codigo, int capacidad, String tipoSorteo, List<User> usuarios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.tipoSorteo = tipoSorteo;
        this.usuarios = usuarios;
    }

    public Grupo(String nombre, String codigo, int capacidad, String tipoSorteo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.tipoSorteo = tipoSorteo;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoSorteo() {
        return tipoSorteo;
    }

    public void setTipoSorteo(String tipoSorteo) {
        this.tipoSorteo = tipoSorteo;
    }

    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }
}

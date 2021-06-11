package com.amigosinvisibles.gdp.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "gustos")
public class Gusto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String codigo;

    @JoinTable(
            name = "gustos_users",
            joinColumns = @JoinColumn(name = "gusto_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name="user_id", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> usuarios;

    public void addUser(User user){
        if(this.usuarios == null){
            this.usuarios = new ArrayList<>();
        }
        this.usuarios.add(user);
    }

    public Gusto(){
        super();
    }

    public Gusto(String nombre, String codigo, List<User> usuarios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.usuarios = usuarios;
    }

    public Gusto(Long id, String nombre, String codigo, List<User> usuarios) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.usuarios = usuarios;
    }

    public Gusto(String nombre, String codigo){
        this.codigo=codigo;
        this.nombre=nombre;
    }

    public Gusto(Long id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
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

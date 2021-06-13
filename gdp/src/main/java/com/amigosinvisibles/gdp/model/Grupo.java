package com.amigosinvisibles.gdp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "grupos")
public class Grupo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;

        @Column(unique = true)
        private String codigo;

        private int capacidad;

        @Column(name = "tipo_sorteo")
        private String tipoSorteo;

        public Grupo() {
            super();
        }



        public Grupo(Long id, String nombre, String codigo, int capacidad, String tipoSorteo, Set<User> usuarios) {
            this.id = id;
            this.nombre = nombre;
            this.codigo = codigo;
            this.capacidad = capacidad;
            this.tipoSorteo = tipoSorteo;
        }

        public Grupo(String nombre, String codigo, int capacidad, String tipoSorteo, Set<User> usuarios) {
            this.nombre = nombre;
            this.codigo = codigo;
            this.capacidad = capacidad;
            this.tipoSorteo = tipoSorteo;
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


}

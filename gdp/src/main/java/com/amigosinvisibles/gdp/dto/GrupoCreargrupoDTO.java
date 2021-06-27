package com.amigosinvisibles.gdp.dto;

import com.amigosinvisibles.gdp.model.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GrupoCreargrupoDTO implements Serializable {

    private Date fechaDelSorteo;
    private List<User> users;

    public GrupoCreargrupoDTO(Date fechaDelSorteo){
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public GrupoCreargrupoDTO(Date fechaDelSorteo, List<User> users){
        this.fechaDelSorteo = fechaDelSorteo;
        this.users = users;
    }

    public Date getFechaDelSorteo() {
        return fechaDelSorteo;
    }

    public void setFechaDelSorteo(Date fechaDelSorteo) {
        this.fechaDelSorteo = fechaDelSorteo;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

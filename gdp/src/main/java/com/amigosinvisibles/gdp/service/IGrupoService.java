package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface IGrupoService {
    Grupo create(Grupo grupo) throws Exception;
    void delete(Long id) throws Exception;
    List<Grupo> listAll();
    Grupo getOne(Long id) throws Exception;
    List<Grupo> listAllUser(Long idUser) throws Exception;
    Boolean existById(Long id);


}

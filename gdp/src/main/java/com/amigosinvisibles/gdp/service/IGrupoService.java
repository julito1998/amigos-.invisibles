package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
<<<<<<< HEAD
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface IGrupoService {
    Grupo create(Grupo grupo) throws Exception;
    void delete(Long id) throws Exception;
    List<Grupo> listAll();
    Grupo getOne(Long id) throws Exception;
    List<Grupo> listAllUser(Long idUser) throws Exception;
    Boolean existById(Long id);
=======

public interface IGrupoService {
    Grupo guardar(Grupo grupo) throws Exception;
>>>>>>> dae2bcab70291dd0e396f3f24d1cc8a3efbc4adb
}

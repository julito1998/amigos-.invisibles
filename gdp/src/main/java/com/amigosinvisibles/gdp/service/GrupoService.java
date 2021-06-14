package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.repository.GrupoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService implements IGrupoService{

    @Autowired
    private GrupoRepo grupoRepo;

    @Override
    public Grupo guardar(Grupo grupo) throws Exception {
        try{
            return grupoRepo.save(grupo);
        }catch (Exception e){
            throw new Exception("algo salio mal" + e.getMessage());
        }

    }
}

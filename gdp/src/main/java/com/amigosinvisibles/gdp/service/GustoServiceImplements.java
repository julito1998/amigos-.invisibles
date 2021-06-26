package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Gusto;
import com.amigosinvisibles.gdp.model.SorteoAsignacion;
import com.amigosinvisibles.gdp.repository.GustoRepo;
import com.amigosinvisibles.gdp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GustoServiceImplements implements IGustoService{

    @Autowired
    private GustoRepo gustoRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Gusto> findAllByUserId(Long idUser) throws Exception {
        try{
            if (!userRepo.existsById(idUser)) throw new Exception("No existen usuarios con este id: " + idUser);
            return gustoRepo.findAllByUserId(idUser);
        }catch (Exception e){
            throw new Exception("Error en el servicio de Gusto por usuario. Error: "+ e.getMessage());
        }
    }

}

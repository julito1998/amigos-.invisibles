package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.repository.GrupoRepo;
import com.amigosinvisibles.gdp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class GrupoService implements IGrupoService{

    @Autowired
    private GrupoRepo repo;

    @Autowired
    private UserRepo userRepo;

    public GrupoService() throws IOException {
    }

    @Override
    public Grupo create(Grupo grupo) throws Exception{
        try{
            return repo.save(grupo);
        }
        catch (Exception e) {
            throw new Exception("Ocurrio un error al intentar crear el grupo");
        }
    }

    @Override
    public List<Grupo> listAlluserByAdmin(Long idUser) throws Exception {
        try{
            if (!userRepo.existsById(idUser)) throw new Exception("Este usuario" + idUser + " no existe.");
            return repo.findAllByUserIdAndAdministraIsTrue(idUser);
        }
        catch (Exception e) {
            throw new Exception("Ocurrio un error en el Servicio del grupo para este codigo de usuario" + idUser);
        }
    }

    @Override
    public void delete(Long id) throws Exception{
        try{
            repo.deleteById(id);
        }
        catch (Exception e){
            throw new Exception("Ocurrio un error al intentar eliminar el grupo con id:" + id);
        }
    }
    @Override
    public List<Grupo> listAll(){
        return repo.findAll();
    }

    @Override
    public Grupo getOne(Long id) throws Exception{
        try {
            if (!this.existById(id)) throw new Exception("Grupo inexistente.");
            return repo.getById(id);
        }
        catch (Exception e){
            throw new Exception("Ocurrio un error en el Servicio del grupo para este codigo de grupo:" + id);
        }
    }

    @Override
    public List<Grupo> listAllUser(Long idUser) throws Exception{
        try{
            if (!userRepo.existsById(idUser)) throw new Exception("Este usuario" + idUser + " no existe.");
            return repo.findAllByUserId(idUser);
        }
        catch (Exception e) {
            throw new Exception("Ocurrio un error en el Servicio del grupo para este codigo de usuario" + idUser);
        }
    }

    @Override
    public Boolean existById(Long id) {
        return repo.existsById(id);
    }

}

package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.repository.GrupoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService implements IGrupoService{

    @Autowired
<<<<<<< HEAD
    private GrupoRepo repo;

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
    public void delete(Long id) throws Exception{
        try{
            repo.deleteById(id);
        }
        catch (Exception e){
            throw new Exception("Ocurrio un error al intentar eliminar el grupo con id:" + String.valueOf(id));
        }
    }
    @Override
    public List<Grupo> listAll(){
        return repo.findAll();
    }

    @Override
    public Grupo getOne(Long id) throws Exception{
        try {
            return repo.getById(id);
        }
        catch (Exception e){
            throw new Exception("Ocurrio un error en el Servicio del grupo para este codigo de grupo:" + id);
        }
    }

    @Override
    public List<Grupo> listAllUser(Long idUser) throws Exception{
        try{
            return repo.findAllByUserId(idUser);
        }
        catch (Exception e) {
            throw new Exception("Ocurrio un error en el Servicio del grupo para este codigo de usuario" + idUser);
        }
    }

=======
    private GrupoRepo grupoRepo;

    @Override
    public Grupo guardar(Grupo grupo) throws Exception {
        try{
            return grupoRepo.save(grupo);
        }catch (Exception e){
            throw new Exception("algo salio mal" + e.getMessage());
        }

    }
>>>>>>> dae2bcab70291dd0e396f3f24d1cc8a3efbc4adb
}

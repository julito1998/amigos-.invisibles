package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.User;
import com.amigosinvisibles.gdp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Julito
 */
@Service
public class UserService implements UserDetailsService, IUserService {

    @Autowired
    private UserRepo repo;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //si no encuentro al usuario al menos debo retornar algo de tipo User
        User user=repo.findByEmail(email);
        //si encuentra al usuario lo retorno
            if(user==null){
                throw new UsernameNotFoundException("error");
            }
        return user;
    }


    @Override
    public User create(User user) throws UsernameNotFoundException {
       //si no existe el email ese en la bd lo guardo

        if(!repo.existsByEmail(user.getEmail())){
           user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
           user=repo.save(user);
       }
        else{
            throw new UsernameNotFoundException("The email : "+ user.getEmail() +" it is already associated with a user. Try Again with another User");
        }
       return user;
    }

    @Override
    public void delete(Long id) throws Exception{
        try{
            repo.deleteById(id);
        }catch (Exception e){
            throw new Exception("Ocurrio un error al intentar eliminar el usuario con id" + id);
        }
    }

    @Override
    public List<User> listAll() {
        return repo.findAll();
    }

    @Override
    public User getOne(Long id) throws Exception{
        try{
            return repo.getById(id);
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
             throw new Exception("No existe el usuario con este codigo de usuario: " + id);
        }
        catch (Exception e){
             throw new Exception("Ocurrio un error en el Servicio del usuario para este codigo de usuario: " + id);
        }
    }

    @Override
    public List<User> listAllGrupo(Long idGrupo) throws Exception {
        try{
            return repo.findAllByGrupos(idGrupo);
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new Exception("No existen usuarios para este codigo de grupo: " + idGrupo);
        }
        catch (Exception e){
            throw new Exception("Ocurrio un error en el Servicio del usuario para este codigo de grupo: " + idGrupo);
        }
    }

    @Override
    public List<User> listAllGusto(Long idGusto) throws Exception {
        try{
            return repo.findAllByGusto(idGusto);
        }catch (EmptyResultDataAccessException emptyResultDataAccessException){
            throw new Exception("No existen usuarios que tengan este codigo de gusto: " + idGusto);
        }
        catch (Exception e){
            throw new Exception("Ocurrio un error en el Servicio del usuario para este codigo de gusto: " + idGusto);
        }
    }

    @Override
    public Integer cantidadGruposAdministrados(Long idUser) {
        return repo.cantidadGruposAdministrados(idUser);
    }

    @Override
    public Integer cantidadGruposParticipados(Long idUser) {
        return repo.cantidadGruposParticipados(idUser);
    }


}

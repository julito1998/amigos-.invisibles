package com.amigosinvisibles.gdp.service;


import com.amigosinvisibles.gdp.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.*;


/**
 *
 * @author Julito
 */
public interface IUserService extends UserDetailsService {
    User create(User user) throws Exception;
    void delete(Long id) throws Exception;
    List<User> listAll();
    User getOne(Long id) throws Exception;
    List<User>listAllGrupo(Long idGrupo) throws Exception;
    List<Long>listAllGrupoById(Long idGrupo) throws Exception;
    List<User>listAllGusto(Long idGusto) throws Exception;
    Integer cantidadGruposAdministrados(Long idUser);
    Integer cantidadGruposParticipados(Long idUser);
    List<User> listUserAsignados(Long idUser) throws Exception;

}

package com.amigosinvisibles.gdp.repository;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.model.SorteoAsignacion;
import com.amigosinvisibles.gdp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface SorteoAsignacionRepo extends JpaRepository<SorteoAsignacion,Long> {
    //obtengo el listado de todos los usuarios a los que les tengo que regalar algo por el sorteo
    @Query("SELECT sa.usuario_invisible FROM SorteoAsignacion sa WHERE sa.usuario_visible=:id_user")
    List<User> listUserAsignados(@Param("id_user")Long idUser);

    //obtengo el grupo, la fecha, el usuario visible y el usuario invisible
    @Query("SELECT sa FROM SorteoAsignacion sa WHERE sa.usuario_visible=:id_user")
    List<SorteoAsignacion> listAsignados(@Param("id_iser")Long idUser);


}



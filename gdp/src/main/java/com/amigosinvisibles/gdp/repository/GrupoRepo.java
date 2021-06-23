package com.amigosinvisibles.gdp.repository;

import com.amigosinvisibles.gdp.model.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GrupoRepo extends JpaRepository<Grupo,Long> {

    List<Grupo> findByNombreLike(String nombre);
    //para chequear y no tener usuarios con el mismo nombre o email
    boolean existsById(Long id);
    boolean existsByCodigo(String codigo);

    Grupo findByCodigo(String codigo);
    @Override
    Grupo getById(Long id);
    void deleteById(Long id);
    @Override
    List<Grupo> findAll();

    //todos los grupos donde la capacidad sea mayor
    @Query(value = "SELECT g FROM Grupo g where g.capacidadMaxima >=:capacidad")
    List<Grupo> findAllByCapacidadAfter(@Param("capacidad")Integer capacidad);

    //todos los grupos donde la capacidad sea menor
    @Query(value = "SELECT g FROM Grupo g where g.capacidadMaxima <=:capacidad")
    List<Grupo> findAllByCapacidadBefore(@Param("capacidad")Integer capacidad);

    //listar todos los grupos con capacidad maximaa entre dos valores ordernado por codigo de grupo
    @Query(value = "SELECT g FROM Grupo g where g.capacidadMaxima between :capacidad_minima and :capacidad_maxima order by g.codigo")
    List<Grupo> findAllByCapacidadBetweenOrderByCodigo(@Param("capacidad_minima")Integer capacidadMinima,@Param("capacidad_minima")Integer capacidadMaxima);

    //listar todos los grupos con este tipo de sorteo
    @Query(value = "SELECT g FROM Grupo g where g.tipoSorteo =:id_tipo_sorteo")
    List<Grupo> findAllByTipoSorteo(@Param("id_tipo_sorteo")Long idTipoSoteo);

    //listar todos los grupos a los que pertecene este usuario
    @Query(value = "SELECT g FROM UserInGrupo u_g "+
            "INNER JOIN Grupo g ON g.id=u_g.grupo.id WHERE u_g.usuario.id=:id_user")
    List<Grupo> findAllByUserId(@Param("id_user")Long idUser);

    //listar todos los grupos a los que pertecene este usuario y ADMINISTRA
    @Query(value = "SELECT g FROM UserInGrupo u_g "+
            "INNER JOIN Grupo g ON g.id=u_g.grupo.id WHERE u_g.isAdmin=true and u_g.usuario.id=:id_user")
    List<Grupo> findAllByUserIdAndAdministraIsTrue(@Param("id_user")Long idUser);

    //listar todos los grupos en donde ya se haya realizado el sorteo ordenado por la fecha en la que se sorteo
    @Query(value = "SELECT g FROM Grupo g INNER JOIN SorteoAsignacion s_a ON g.id=s_a.grupo.id " +
            "INNER JOIN UserInGrupo u_g ON u_g.grupo.id=s_a.grupo.id where u_g.usuario.id=:id_user " +
            " order by s_a.fechaSorteo desc")
    List<Grupo> findAllBySorteado(@Param("id_user")Long idUser);


    //listar todos los grupos en donde no se
    // haya realizado el sorteo ordenado por la fecha en la que se puso el limite de la del grupo.
    @Query(value = "SELECT g FROM Grupo g INNER JOIN " +
            "UserInGrupo u_g ON u_g.grupo.id=g.id where u_g.usuario.id=:id_user and g.id NOT IN " +
            "(select s_a.grupo.id from SorteoAsignacion s_a) " +
            "order by g.fechaLimite desc")
    List<Grupo> findAllByNoSorteado(@Param("id_user")Long idUser);

    //obtener los grupos por fecha limite
    @Query(value = "SELECT g FROM Grupo g where g.fechaLimite=:fecha")
    List<Grupo> findAllFechaLimite(@Param("fecha")Date fecha);

    //obtener el tipo de sorteo del grupo
    @Query(value = "SELECT ts.id from Grupo g INNER JOIN TipoSorteo ts ON g.tipoSorteo.id=ts.id")
    Long findAllTipoSorteo();
}

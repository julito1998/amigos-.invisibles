package com.amigosinvisibles.gdp.repository;

import com.amigosinvisibles.gdp.model.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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

    List<Grupo> findAllByCapacidadAfter(int capacidad);
    List<Grupo> findAllByCapacidadBefore(int capacidad);
    List<Grupo> findAllByCapacidadBetweenOrderByCodigo(int capacidad1, int capacidad2);
    List<Grupo> findAllByTipoSorteo(String tipoSorteo);

    @Query(value = "SELECT g FROM UserInGrupo u_g "+
            "INNER JOIN Grupo g ON g.id=u_g.grupo.id WHERE u_g.usuario.id=:id_user")
    List<Grupo> findAllByUserId(@Param("id_user")Long idUser);

}

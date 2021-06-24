package com.amigosinvisibles.gdp.repository;

import com.amigosinvisibles.gdp.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.amigosinvisibles.gdp.model.Gusto;

import java.util.List;

@Repository
public interface GustoRepo extends JpaRepository<Gusto,Long> {

    @Query(value = "SELECT g FROM gustos g "+
            "INNER JOIN gustos_users g_u ON g.id=g_u.gusto_id WHERE g_u.user_id=:id_user",nativeQuery = true)
    List<Gusto> findAllByUserId(@Param("id_user")Long idUser);
}

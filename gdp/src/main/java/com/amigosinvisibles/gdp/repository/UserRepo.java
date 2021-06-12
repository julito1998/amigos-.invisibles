package com.amigosinvisibles.gdp.repository;

import com.amigosinvisibles.gdp.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Julito
 */
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String email);
   //para chequear y no tener usuarios con el mismo nombre o email
    boolean existsByEmail(String email);
    User findByPassword(String password);
    User findByUserName(String userName);
    boolean existsByUserName(String userName);
    @Override
    User getById(Long id);
    void deleteById(Long id);
    @Override
    List<User> findAll();

    //todos los usuarios que tengan este id de gusto
    @Query(value = "SELECT u FROM users u INNER JOIN gustos_users g_u ON u.id=g_u.user_id " +
                    "INNER JOIN gustos g ON g.id=g_u.gusto_id WHERE g.id=:id_gusto",nativeQuery = true)
    List<User>findAllByGusto(@Param("id_gusto")Long idGusto);

    //todos los usuarios de un grupo por id de grupo
    @Query(value = "SELECT u FROM User u INNER JOIN UserInGrupo u_g ON u.id=u_g.usuario.id " +
            "INNER JOIN Grupo g ON g.id=u_g.grupo.id WHERE g.id=:id_grupo")
    List<User>findAllByGrupos(@Param("id_grupo")Long idGusto);
}

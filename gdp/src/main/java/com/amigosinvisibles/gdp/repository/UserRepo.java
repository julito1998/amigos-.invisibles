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
    @Query(value = "SELECT u.* FROM users u INNER JOIN gustos_users g_u ON u.id=g_u.user_id " +
                    "WHERE g_u.gusto_id=:id_gusto",nativeQuery = true)
    List<User>findAllByGusto(@Param("id_gusto")Long idGusto);

    //todos los usuarios de un grupo por id de grupo
    @Query(value = "SELECT u FROM User u INNER JOIN UserInGrupo u_g ON u.id=u_g.usuario.id " +
            "WHERE u_g.grupo.id=:id_grupo")
    List<User>findAllByGrupos(@Param("id_grupo")Long idGusto);
  // obtengo todos los id de los usuarios de un grupo
   @Query(value = "SELECT u.id FROM User u INNER JOIN UserInGrupo u_g ON u.id=u_g.usuario.id " +
                   "WHERE u_g.grupo.id=:id_grupo")
    List<Long>listAllGrupoById(@Param("id_grupo")Long idGusto);

    @Query(value = "SELECT count(grupo) from UserInGrupo where usuario.id=:id_user and isAdmin=true")
    Integer cantidadGruposAdministrados(@Param("id_user")Long idUser);

  @Query(value = "SELECT count(grupo) from UserInGrupo where usuario.id=:id_user and isAdmin=false")
  Integer cantidadGruposParticipados(@Param("id_user")Long idUser);

}

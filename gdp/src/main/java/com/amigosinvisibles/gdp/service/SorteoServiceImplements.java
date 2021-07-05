package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.model.SorteoAsignacion;
import com.amigosinvisibles.gdp.model.User;
import com.amigosinvisibles.gdp.repository.SorteoAsignacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SorteoServiceImplements  implements ISorteoAsignacionService{

    @Autowired
    private SorteoAsignacionRepo sorteoAsignacionRepo;

    @Autowired
    private IGrupoService grupoService;

    @Autowired
    private IUserService userService;

    @Override
    public List<SorteoAsignacion> listAsignados(Long idUser) throws Exception {
        try{
            return sorteoAsignacionRepo.listAsignados(idUser);
        }catch (Exception e){
            throw new Exception("Error en el servicio de Sorteo Asignacion por usuario. Error: "+ e.getMessage());
        }
    }


    //realizo el sorteo para todos los grupos una vez por dia
    @Override
    public void realizarSorteo(Grupo grupo) throws Exception {
        try {
                //creo el objeto sorteoAsignacion
                SorteoAsignacion sorteoAsignacion = new SorteoAsignacion();
                //le seteo el grupo
                sorteoAsignacion.setGrupo(grupo);

                //obtengo una lista con todos los id de los usuarios que estan dentro del grupo
                ArrayList<Long> users = new ArrayList<>(userService.listAllGrupoById(grupo.getId()));

                int contador = 1;

                //recorro la lista de los ID de usuarios
                for (int i = 0; i < users.size(); i++) {
                    //obtengo una posicion al azar en la lista
                    Integer posicion = (int) Math.random() * users.size();

                    if (contador == 3) {
                        //en la tercera iteracion seteo la fecha del sorteo
                        sorteoAsignacion.setFechaSorteo(new Date());
                        //guardo el la asignacion del Sorteo
                        sorteoAsignacionRepo.save(sorteoAsignacion);

                        //reinicio el objeto del sorteo
                        sorteoAsignacion = new SorteoAsignacion();
                        //reinicio el contador
                        contador = 1;
                    }

                    switch (contador) {
                        case 1:
                            //obtengo el usuario visible por su ID
                            User userVisible = userService.getOne(users.get(posicion));
                            //lo agrego al sorteoAsignacion
                            sorteoAsignacion.setUsuario_visible(userVisible);
                            break;
                        case 2:
                            //cada 2 iteraciones seteo el id del usuario invisible
                            User userInvisible = userService.getOne(users.get(posicion));
                            sorteoAsignacion.setUsuario_invisible(userInvisible);
                            break;
                    }
                    contador = +1;
                    //elmino la posicion
                    users.remove(posicion);
                }
        }catch (Exception e){
            throw new Exception("Error en el servicio de Sorteo Asignacion al intentar realizar el sorteo al azar." + e.getMessage());
        }
    }



    //reviso que grupos cumplen con la condicion para ir generando el sorteo
    @Override
    @Scheduled(fixedDelay = 86400000L)
     public void guardarSorteoAutomatico() throws Exception{

        for (Grupo g: grupoService.listAll()) {
            switch (String.valueOf(g.getTipoSorteo().getId())) {
                // el tipo de sorteo es por fecha
                case "1":
                    if (g.getTipoSorteo().getFechaDelSorteo().after(new Date())){
                        try{
                            realizarSorteo(g);
                        }catch (Exception e){
                            throw new Exception("Error en el servicio de Sorteo al intentar realizarlo de forma automatica por Fecha. Error: "+ e.getMessage());
                        }
                    }
                    break;
                //el sorteo se realiza cuando se llega a una cantidad maxima de participantes
                case "2":
                    if(g.getCapacidadMaxima()==g.getTipoSorteo().getCapacidadMaxima()){
                        try{
                            realizarSorteo(g);
                        }catch (Exception e){
                            throw new Exception("Error en el servicio de Sorteo al intentar realizarlo de forma automatica por Capacidad Maxima. Error: "+ e.getMessage());
                        }
                    }
                    break;
                //el admin realiza el sorteo es decir no hago nada
                case "3":
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public SorteoAsignacion guardarAsignacionDelSorteo(SorteoAsignacion sorteoAsignacion) throws Exception {
        try{
            return sorteoAsignacionRepo.save(sorteoAsignacion);
        }catch (Exception e){
            throw new Exception("Error en el servicio de Sorteo Asignacion al intentar Guardar. Error: "+ e.getMessage());
        }
    }
}

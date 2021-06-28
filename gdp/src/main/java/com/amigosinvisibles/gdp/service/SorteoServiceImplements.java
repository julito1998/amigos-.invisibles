package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.model.SorteoAsignacion;
import com.amigosinvisibles.gdp.model.User;
import com.amigosinvisibles.gdp.repository.SorteoAsignacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
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




    private void guardarSorteoAutomatico(){
        List<Grupo> grupoList= new ArrayList<>();

        for (Grupo g: grupoService.listAll()) {
            switch (String.valueOf(g.getTipoSorteo().getId())) {
                // el tipo de sorteo es por fecha
                case "1":
                    if (g.getTipoSorteo().getFechaDelSorteo().after(new Date())) grupoList.add(g);
                    break;
                //el admin realizo el sorteo
                case "2":
                    break;
                //el sorteo se realiza cuando se llega a una cantidad maxima de participantes
                case "3":
                    if(g.getCapacidadMaxima()==g.getTipoSorteo().getCapacidadMaxima()) grupoList.add(g);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public SorteoAsignacion guardarAsignacionDelSorteo(SorteoAsignacion sorteoAsignacion) throws Exception {
        try{

            //crear algoritmo al azar entre los distintos usuarios
            //crear la ejecucion automatica del sorteo cada 24 horas, dependiendo del tipo
            //fecha limite, capacidad maxima o el admin presiona el botton sortear

            return sorteoAsignacionRepo.save(sorteoAsignacion);
        }catch (Exception e){
            throw new Exception("Error en el servicio de Sorteo Asignacion al intentar Guardar. Error: "+ e.getMessage());
        }
    }
}

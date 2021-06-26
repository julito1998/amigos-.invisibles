package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.model.SorteoAsignacion;
import com.amigosinvisibles.gdp.repository.SorteoAsignacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SorteoServiceImplements  implements ISorteoAsignacionService{

    @Autowired
    private SorteoAsignacionRepo sorteoAsignacionRepo;

    @Override
    public List<SorteoAsignacion> listAsignados(Long idUser) throws Exception {
        try{
            return sorteoAsignacionRepo.listAsignados(idUser);
        }catch (Exception e){
            throw new Exception("Error en el servicio de Sorteo Asignacion por usuario. Error: "+ e.getMessage());
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

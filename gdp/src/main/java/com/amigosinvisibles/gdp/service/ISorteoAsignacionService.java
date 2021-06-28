package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.model.SorteoAsignacion;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISorteoAsignacionService {
    List<SorteoAsignacion> listAsignados(Long idUser) throws Exception;
    SorteoAsignacion guardarAsignacionDelSorteo(SorteoAsignacion sorteoAsignacion) throws Exception;
    void guardarSorteoAutomatico () throws Exception;
    void realizarSorteo(Grupo grupo) throws Exception;
}

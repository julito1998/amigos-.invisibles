package com.amigosinvisibles.gdp.service;

import com.amigosinvisibles.gdp.model.Gusto;

import java.util.List;

public interface IGustoService {

    List<Gusto> findAllByUserId(Long idUser) throws Exception;
}

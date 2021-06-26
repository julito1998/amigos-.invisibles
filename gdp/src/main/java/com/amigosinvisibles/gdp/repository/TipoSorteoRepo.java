package com.amigosinvisibles.gdp.repository;

import com.amigosinvisibles.gdp.model.TipoSorteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSorteoRepo extends JpaRepository<TipoSorteo,Long>{
}

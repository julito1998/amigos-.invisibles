package com.amigosinvisibles.gdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSorteo extends JpaRepository<TipoSorteo,Long> {
}

package com.amigosinvisibles.gdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.amigosinvisibles.gdp.model.Gusto;
@Repository
public interface GustoRepo extends JpaRepository<Gusto,Long> {
}

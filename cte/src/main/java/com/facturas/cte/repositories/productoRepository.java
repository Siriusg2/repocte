package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.productoModel;


public interface productoRepository extends JpaRepository<productoModel, Long> {
    
}

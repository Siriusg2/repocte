package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.detalleModel;

public interface detalleRepository extends JpaRepository<detalleModel, Long>{
    
}

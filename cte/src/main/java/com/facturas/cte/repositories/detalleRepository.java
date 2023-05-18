package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.DetalleModel;

public interface DetalleRepository extends JpaRepository<DetalleModel, Long>{
    
}

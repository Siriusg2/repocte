package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.ProductoModel;


public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
    
}

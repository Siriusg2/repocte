package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.clienteModel;

public interface clienteRepository extends JpaRepository<clienteModel, Long>{
    
}

package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
    
}

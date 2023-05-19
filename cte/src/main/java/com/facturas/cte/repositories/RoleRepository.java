package com.facturas.cte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long>  {
    
}

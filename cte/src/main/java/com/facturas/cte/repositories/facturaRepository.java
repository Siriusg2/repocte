package com.facturas.cte.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.FacturaModel;

public interface FacturaRepository  extends JpaRepository<FacturaModel, Long>{
    
}

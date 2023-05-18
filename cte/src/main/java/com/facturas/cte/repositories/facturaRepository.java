package com.facturas.cte.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.facturas.cte.models.*;

public interface facturaRepository  extends JpaRepository<facturaModel, Long>{
    
}

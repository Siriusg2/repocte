package com.facturas.cte.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.facturas.cte.models.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    UsuarioModel findByEmail(String email);
    
}

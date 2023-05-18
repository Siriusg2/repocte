package com.facturas.cte.utils.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facturas.cte.repositories.ClienteRepository;

@Component
public class ClienteValidation {
    
    @Autowired
    ClienteRepository clienteRepository;
}

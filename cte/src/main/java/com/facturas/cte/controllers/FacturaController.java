package com.facturas.cte.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facturas.cte.models.FacturaModel;
import com.facturas.cte.services.FacturaService;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    FacturaService facturaService;
    
@GetMapping("/get_all")
public ResponseEntity <List<FacturaModel>> getAllFacturas ( ) throws Exception{

List<FacturaModel> allFacturas = facturaService.getAllFacturas();

return ResponseEntity.status(HttpStatus.OK).body(allFacturas);

}

@PostMapping("/create")

public ResponseEntity<FacturaModel> saveFactura(@RequestBody FacturaModel facturaData) throws Exception{

FacturaModel newFactura = facturaService.saveFactura(facturaData);

return ResponseEntity.status(HttpStatus.CREATED).body(newFactura);

} 

}

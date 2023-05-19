package com.facturas.cte.controllers;

import com.facturas.cte.models.ClienteModel;
import com.facturas.cte.services.ClienteService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class ClienteController {

  @Autowired
  ClienteService clientService;

  @GetMapping("/get_all")
  public ResponseEntity<List<ClienteModel>> getAll() throws Exception {
    List<ClienteModel> allClients = clientService.getAllClients();

    return ResponseEntity.status(HttpStatus.OK).body(allClients);
  }

  @PostMapping("/create")
  public ResponseEntity<ClienteModel> saveClient(
    @RequestBody ClienteModel clientData,
    @RequestHeader Map<String, String> headers
  ) throws Exception {

    String idCreator = headers.get("id");
    Long parseLongId = Long.parseLong(idCreator);

    ClienteModel newClient = clientService.saveClient(clientData, parseLongId);

    return ResponseEntity.status(HttpStatus.CREATED).body(newClient);

    
  }
}

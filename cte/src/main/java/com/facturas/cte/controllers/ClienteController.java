package com.facturas.cte.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.facturas.cte.models.ClienteModel;
import com.facturas.cte.services.ClienteService;


@RestController
@RequestMapping("/customers")
public class ClienteController {
    @Autowired
    ClienteService clientService;

    @GetMapping("/get_all")
    public List<ClienteModel> getAll() throws Exception {

       return clientService.getAllClients();

    }
}

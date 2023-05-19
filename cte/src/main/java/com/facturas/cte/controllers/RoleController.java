package com.facturas.cte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.facturas.cte.services.RoleService;

@RestController
public class RoleController {
    

    @Autowired
    RoleService roleService;
}

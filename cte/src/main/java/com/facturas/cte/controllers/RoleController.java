package com.facturas.cte.controllers;

import com.facturas.cte.models.RoleModel;
import com.facturas.cte.services.RoleService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

  @Autowired
  RoleService roleService;

  @GetMapping("get_all")
  public ResponseEntity<List<RoleModel>> getAllRoles() throws Exception {
    List<RoleModel> allRoles = roleService.getAllRoles();

    return ResponseEntity.status(HttpStatus.OK).body(allRoles);
  }
}

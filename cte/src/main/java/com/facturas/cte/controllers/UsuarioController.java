package com.facturas.cte.controllers;

import com.facturas.cte.models.UsuarioModel;
import com.facturas.cte.services.UsuarioService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsuarioController {

  @Autowired
  UsuarioService usuarioService;

  @PostMapping("/create")
  public ResponseEntity<UsuarioModel> createUsuario(
    @RequestBody UsuarioModel userData,
    @RequestHeader Map<String, String> headers
  ) throws Exception {
    String idCreator = headers.get("id");
    Long parseLongId = Long.parseLong(idCreator);
    UsuarioModel savedUser = usuarioService.saveUser(userData, parseLongId);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }

  @GetMapping("/get_all")
  public ResponseEntity<List<UsuarioModel>> getAllUsers() throws Exception {
    List<UsuarioModel> allUsers = usuarioService.getAllUsers();

    return ResponseEntity.status(HttpStatus.OK).body(allUsers);
  }

  @PostMapping("/login")
  public ResponseEntity<UsuarioModel> userLogin(
    @RequestBody Map<String, String> credentials
  ) throws Exception {
    String userEmail = credentials.get("email");
    String userPassword = credentials.get("password");

    UsuarioModel usuario = usuarioService.login(userEmail, userPassword);

    return ResponseEntity.ok().body(usuario);
  }
}

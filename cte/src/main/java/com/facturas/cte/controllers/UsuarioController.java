package com.facturas.cte.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facturas.cte.models.UsuarioModel;
import com.facturas.cte.services.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/create")
    public ResponseEntity<UsuarioModel> createUsuario(@RequestBody UsuarioModel userData, @RequestHeader Long idCreator) throws Exception{

        

        UsuarioModel savedUser =  usuarioService.saveUser(userData, idCreator);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
}
}

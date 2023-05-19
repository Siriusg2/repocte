package com.facturas.cte.utils.validations;

import com.facturas.cte.models.ClienteModel;
import com.facturas.cte.models.UsuarioModel;
import com.facturas.cte.repositories.ClienteRepository;
import com.facturas.cte.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidation {

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  public void validateSaveClient(
    String ciRuclCient,
    String correo,
    Long idCreator
  ) throws Exception {
    ClienteModel existingClient = clienteRepository.findByIdentificacion(
      ciRuclCient
    );

    UsuarioModel clientCreator = usuarioRepository
      .findById(idCreator)
      .orElse(null);

    if (existingClient != null) {
        if (clientCreator != null) {
          if (clientCreator.getRole().getId() > 1) {
            throw new Exception("No tienes permisos para crear al cliente");
          }
        }
      if (existingClient.getIdentificacion().equals(ciRuclCient)) {
        throw new Exception("Ya existe un cliente con esa cedula / ruc");
      }
      if (existingClient.getCorreo().equals(correo)) {
        throw new Exception("Ya existe un cliente con ese correo electronico");
      }
    }
  }
}

package com.facturas.cte.services;

import java.util.List;

import com.facturas.cte.models.UsuarioModel;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
    List<UsuarioModel> getAllUsers() throws Exception;

    UsuarioModel saveUser(UsuarioModel userData, Long idCreator) throws Exception;
    Boolean deteteUser(Long idUser) throws Exception;
    UsuarioModel updateUser(Long idUser, UsuarioModel newUserData ) throws Exception;
}

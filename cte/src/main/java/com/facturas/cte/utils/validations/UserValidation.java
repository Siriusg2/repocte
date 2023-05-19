package com.facturas.cte.utils.validations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facturas.cte.models.UsuarioModel;
import com.facturas.cte.repositories.UsuarioRepository;

@Component
public class UserValidation {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public void userValidationLogin(String email, String password) throws Exception{

UsuarioModel existingUser = usuarioRepository.findByEmail(email);



if(existingUser == null){
    throw new Exception("No existe un usuario registrado con ese correo electronico");
}
if(!existingUser.getPassword().equals(password)){
    throw new Exception("La contraseña no es correcta");
}


}

public Boolean userCreateValidation(Long creatorId)throws Exception{

Optional<UsuarioModel> usuarioCreadorExiste = usuarioRepository.findById(creatorId);

UsuarioModel usuarioCreador = usuarioCreadorExiste.get();

if(usuarioCreador.getRole().getId() != 1 ){
    throw new Exception("No tienes permisos para crear nuevos usuarios");
}

return true;
}
}
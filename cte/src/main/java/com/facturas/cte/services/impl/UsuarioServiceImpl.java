package com.facturas.cte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturas.cte.models.UsuarioModel;
import com.facturas.cte.repositories.UsuarioRepository;
import com.facturas.cte.services.UsuarioService;
import com.facturas.cte.utils.validations.UserValidation;
@Service
public class UsuarioServiceImpl implements UsuarioService{


    @Autowired 
    UsuarioRepository usuarioRepository;
    @Autowired 
    UserValidation userValidation;

    
    @Override
    public List<UsuarioModel> getAllUsers() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    @Override
    public UsuarioModel saveUser(UsuarioModel userData, Long idCreator) throws Exception {
     
        userValidation.userCreateValidation(idCreator);

      
            UsuarioModel newUser = usuarioRepository.save(userData);

            return newUser;
        


    }

    @Override
    public Boolean deteteUser(Long idUser) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deteteUser'");
    }

    @Override
    public UsuarioModel updateUser(Long idUser, UsuarioModel newUserData) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }


    
}

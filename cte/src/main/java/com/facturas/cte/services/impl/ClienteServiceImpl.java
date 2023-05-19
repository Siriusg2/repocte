package com.facturas.cte.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturas.cte.models.ClienteModel;
import com.facturas.cte.repositories.ClienteRepository;
import com.facturas.cte.services.ClienteService;
import com.facturas.cte.utils.validations.ClienteValidation;
@Service
public class ClienteServiceImpl implements ClienteService  {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteValidation clienteValidation;

    @Override
    public List<ClienteModel> getAllClients() throws Exception {
        return clienteRepository.findAll();

    }

    @Override
    public ClienteModel saveClient(ClienteModel clientData, Long idCreator) throws Exception {
       

        String ciRucClient = clientData.getIdentificacion();
        String emailClient = clientData.getCorreo();


clienteValidation.validateSaveClient(ciRucClient, emailClient, idCreator);

ClienteModel newClient =  clienteRepository.save(clientData);

return newClient;


    }

    @Override
    public Boolean deleteClient(Long requestParams) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteClient'");
    }

    @Override
    public ClienteModel updateClient(Long clientId, ClienteModel newDataClient) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateClient'");
    }
    
}

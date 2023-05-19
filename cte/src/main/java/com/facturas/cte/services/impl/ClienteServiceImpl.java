package com.facturas.cte.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturas.cte.models.ClienteModel;
import com.facturas.cte.repositories.ClienteRepository;
import com.facturas.cte.services.ClienteService;
@Service
public class ClienteServiceImpl implements ClienteService  {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<ClienteModel> getAllClients() throws Exception {
        return clienteRepository.findAll();

    }

    @Override
    public ClienteModel saveClient(ClienteModel requesBody) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveClient'");
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

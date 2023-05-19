package com.facturas.cte.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturas.cte.models.ClienteModel;
@Service
public interface ClienteService {
   List<ClienteModel> getAllClients() throws Exception;

ClienteModel saveClient(ClienteModel clientData, Long roleIdCreator) throws Exception;
Boolean deleteClient(Long requestParams) throws Exception;
ClienteModel updateClient(Long clientId, ClienteModel newDataClient ) throws Exception;

}

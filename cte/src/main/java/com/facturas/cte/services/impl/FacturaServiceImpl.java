package com.facturas.cte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturas.cte.models.FacturaModel;
import com.facturas.cte.repositories.FacturaRepository;
import com.facturas.cte.services.FacturaService;
@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository   facturaRepository;

    @Override
    public List<FacturaModel> getAllFacturas() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFacturas'");
    }

    @Override
    public List<FacturaModel> getAllFacturasByClientId(Long idClient) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFacturasByClientId'");
    }

    @Override
    public FacturaModel saveFactura(FacturaModel facturaData) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveFactura'");
    }

    @Override
    public Boolean deleteFactura(Long requestParams) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFactura'");
    }

    @Override
    public FacturaModel updateFactura(Long clientId, FacturaModel newDataClient) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFactura'");
    }
    
}

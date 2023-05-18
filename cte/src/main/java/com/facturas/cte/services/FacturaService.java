package com.facturas.cte.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.facturas.cte.models.FacturaModel;

@Service
public interface FacturaService {
    List<FacturaModel> getAllFacturas() throws Exception;
    List<FacturaModel> getAllFacturasByClientId(Long idClient) throws Exception;

    FacturaModel saveFactura(FacturaModel facturaData) throws Exception;
    Boolean deleteFactura(Long requestParams) throws Exception;
    FacturaModel updateFactura(Long clientId, FacturaModel newDataClient ) throws Exception;
}

package com.facturas.cte.services;

import org.springframework.stereotype.Service;

import com.facturas.cte.models.DetalleModel;

@Service
public interface DetalleService {


    DetalleModel saveDetalle(DetalleModel requesBody) throws Exception;
    Boolean deleteDetalle(Long requestParams) throws Exception;
    DetalleModel updateDetalles(Long clientId, DetalleModel newDataClient ) throws Exception;
}

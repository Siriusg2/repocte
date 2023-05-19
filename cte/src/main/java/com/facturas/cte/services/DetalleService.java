package com.facturas.cte.services;

import com.facturas.cte.models.DetalleModel;
import org.springframework.stereotype.Service;

@Service
public interface DetalleService {
  DetalleModel saveDetalle(DetalleModel requesBody) throws Exception;
  Boolean deleteDetalle(Long requestParams) throws Exception;
  DetalleModel updateDetalles(Long clientId, DetalleModel newDataClient)
    throws Exception;
}

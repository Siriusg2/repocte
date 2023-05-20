package com.facturas.cte.services.impl;

import com.facturas.cte.models.FacturaModel;
import com.facturas.cte.repositories.DetalleRepository;
import com.facturas.cte.repositories.FacturaRepository;
import com.facturas.cte.services.FacturaService;
import com.facturas.cte.utils.generators.NumFacturaGenerator;
import com.facturas.cte.utils.validations.FacturaValidations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl implements FacturaService {

  @Autowired
  FacturaRepository facturaRepository;

  @Autowired
  DetalleRepository detalleRepository;

  @Autowired
  FacturaValidations facturaValidations;




  @Override
  public List<FacturaModel> getAllFacturas() throws Exception {


    List<FacturaModel> allFacturas = facturaRepository.findAll();



    return allFacturas;
  }

  @Override
  public List<FacturaModel> getAllFacturasByClientId(Long idClient)
    throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'getAllFacturasByClientId'"
    );
  }

  @Override
  public FacturaModel saveFactura(FacturaModel facturaData) throws Exception {
NumFacturaGenerator generator = new NumFacturaGenerator();

List<FacturaModel> allFacturas = facturaRepository.findAll();

String newNumberFact = generator.generarNumeroFactura(allFacturas);


   facturaData.setNumeroFactura(newNumberFact);
try {
  
  facturaValidations.validationSaveFactura(facturaData);
  FacturaModel newFactura = facturaRepository
.save(facturaData);
return newFactura;
} catch (Exception e) {
throw new Exception(e.getMessage());
}





  }

  @Override
  public Boolean deleteFactura(Long requestParams) throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'deleteFactura'"
    );
  }

  @Override
  public FacturaModel updateFactura(Long clientId, FacturaModel newDataClient)
    throws Exception {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
      "Unimplemented method 'updateFactura'"
    );
  }
}

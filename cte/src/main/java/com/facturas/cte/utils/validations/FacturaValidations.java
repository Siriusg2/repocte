package com.facturas.cte.utils.validations;

import com.facturas.cte.models.FacturaModel;
import com.facturas.cte.repositories.FacturaRepository;
import java.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacturaValidations {

  @Autowired
  FacturaRepository facturaRepository;

  public void validationSaveFactura(FacturaModel facturaData) throws Exception {
    String numeroFactura = facturaData.getNumeroFactura();

    LocalDate fechaFactura = facturaData.getFecha();
    LocalDate fechaActual = LocalDate.now();


    if (fechaFactura.isAfter(fechaActual)) {
      throw new Exception(
        "La fecha de la factura no debe ser posterior a la fecha actual"
      );
    }

    if (numeroFactura.length() < 15) {
      throw new Exception(
        "El numero de la factura debe tener al menos 15 digitos"
      );
    }

    if (!numeroFactura.matches("\\d{3}-\\d{3}-\\d{9}")) {
      throw new Exception(
        "El numero de la factura debe cumplir con el siguiente formato ej: 123-456-789012345"
      );
    }
  }
}

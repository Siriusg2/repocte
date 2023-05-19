package com.facturas.cte.utils.validations;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.facturas.cte.models.ProductoModel;
import com.facturas.cte.repositories.ProductoRepository;

@Component
public class ProductValidations {
    

    @Autowired
    ProductoRepository productoRepository;


public Boolean validateNewProduct (ProductoModel productData) throws Exception {


    String productCode = productData.getCodigo();

    ProductoModel existingWithCode = productoRepository.findByCodigo(productCode);

    if (existingWithCode != null) {
        if(productCode.equals(existingWithCode.getCodigo())){
                throw new Exception("Ya existe un producto con ese codigo");
            }
    }

    return true;
}

}

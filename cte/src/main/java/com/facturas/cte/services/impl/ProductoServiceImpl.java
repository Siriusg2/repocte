package com.facturas.cte.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.facturas.cte.models.ProductoModel;
import com.facturas.cte.services.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService{

    @Override
    public List<ProductoModel> getAllFacturas() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFacturas'");
    }

    @Override
    public List<ProductoModel> getAllProductsByClientId(Long idClient) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProductsByClientId'");
    }

    @Override
    public ProductoModel saveProduct(ProductoModel productData) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveProduct'");
    }

    @Override
    public Boolean deleteProduct(Long requestParams) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }

    @Override
    public ProductoModel updateProduct(Long idProduct, ProductoModel newDataProduct) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }
    
}

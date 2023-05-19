package com.facturas.cte.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturas.cte.models.ProductoModel;
import com.facturas.cte.repositories.ProductoRepository;
import com.facturas.cte.services.ProductoService;
import com.facturas.cte.utils.validations.ProductValidations;
@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    ProductValidations productValidations;

    @Override
    public List<ProductoModel> getAllProducts() throws Exception {
     return productoRepository.findAll();
    }

    @Override
    public List<ProductoModel> getAllProductsByClientId(Long idClient) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllProductsByClientId'");
    }

    @Override
    public ProductoModel saveProduct(ProductoModel productData) throws Exception {
      
        productValidations.validateNewProduct(productData);
        
        
        return productoRepository.save(productData);
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

package com.facturas.cte.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.facturas.cte.models.ProductoModel;

@Service
public interface ProductoService {
    List<ProductoModel> getAllProducts() throws Exception;
    List<ProductoModel> getAllProductsByClientId(Long idClient) throws Exception;

    ProductoModel saveProduct(ProductoModel productData) throws Exception;
    Boolean deleteProduct(Long requestParams) throws Exception;
    ProductoModel updateProduct(Long idProduct, ProductoModel newDataProduct ) throws Exception;
}

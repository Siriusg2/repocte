package com.facturas.cte.controllers;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.facturas.cte.models.ProductoModel;
import com.facturas.cte.services.ProductoService;

@RestController
@RequestMapping("/products")
public class ProductoController {
    
@Autowired
ProductoService productoService;



@GetMapping("/get_all")
public ResponseEntity <List<ProductoModel>> getAllProducts() throws Exception{

    List<ProductoModel> allProducts = productoService.getAllProducts();
    
    return ResponseEntity.status(HttpStatus.OK).body(allProducts);
}
@PostMapping("/create")
public ResponseEntity<ProductoModel> saveNewProduct(@RequestBody Map<String, String> productData) throws Exception{
    

    String productCode = productData.get("codigo");
    String productDescription = productData.get("descripcion");
    String productCategory = productData.get("categoria");

    ProductoModel product = new ProductoModel();

    product.setCodigo(productCode);
    product.setDescripcion(productDescription);
    product.setCategoria(productCategory);
try {
    ProductoModel newProduct =  productoService.saveProduct(product);

      return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
} catch (Exception e) {
   throw new Exception(e.getMessage());
}
}

}

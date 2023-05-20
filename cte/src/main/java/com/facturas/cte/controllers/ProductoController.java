package com.facturas.cte.controllers;

import com.facturas.cte.models.ProductoModel;
import com.facturas.cte.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductoController {

  @Autowired
  ProductoService productoService;

  @GetMapping("/get_all")
  public ResponseEntity<List<ProductoModel>> getAllProducts() throws Exception {
    List<ProductoModel> allProducts = productoService.getAllProducts();

    return ResponseEntity.status(HttpStatus.OK).body(allProducts);
  }

  @PostMapping("/create")
  public ResponseEntity<ProductoModel> saveNewProduct(
    @RequestBody ProductoModel productData
  ) throws Exception {
    ProductoModel newProduct = productoService.saveProduct(productData);

    return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
  }
}

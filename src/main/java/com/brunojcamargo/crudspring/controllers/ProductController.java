package com.brunojcamargo.crudspring.controllers;

import com.brunojcamargo.crudspring.domain.product.Product;
import com.brunojcamargo.crudspring.domain.product.ProductDTO;
import com.brunojcamargo.crudspring.services.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData){
        Product newProduct = this.productService.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.productService.getAll();
        return ResponseEntity.ok().body(products);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathParam("id") String id, @RequestBody ProductDTO productData){
        Product updatedProduct = this.productService.update(id, productData);
        return ResponseEntity.ok().body(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathParam("id") String id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

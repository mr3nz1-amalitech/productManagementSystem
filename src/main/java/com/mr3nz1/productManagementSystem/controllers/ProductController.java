package com.mr3nz1.productManagementSystem.controllers;

import com.mr3nz1.productManagementSystem.models.Product;
import com.mr3nz1.productManagementSystem.services.ProductService;
import com.mr3nz1.productManagementSystem.utils.NullChecker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(required = false) String category
    ) {
        return productService.getProducts(page, size, sortBy, category);
    }

    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        if (NullChecker.check(product)) {
            return new ResponseEntity<>("Error adding product. Submit all fields", HttpStatus.BAD_REQUEST);
        }


        productService.addProduct(product);
        return new ResponseEntity<>("Success adding product", HttpStatus.OK);
    }
}

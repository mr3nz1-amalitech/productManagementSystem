package com.mr3nz1.productManagementSystem.services;

import com.mr3nz1.productManagementSystem.models.Category;
import com.mr3nz1.productManagementSystem.models.Product;
import com.mr3nz1.productManagementSystem.repositories.CategoryRepository;
import com.mr3nz1.productManagementSystem.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addProduct(Product product) {
        product.setId(UUID.randomUUID());
        product.setName(product.getName().toLowerCase());
        productRepository.save(product);
    }

    public List<Product> getProducts(int page, int size, String sortBy, String categoryName) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        if (categoryName == null) return productRepository.findAll(pageable).get().toList();

        System.out.println(categoryName);

        Category category = categoryRepository.findCategoryByExactName(categoryName.toLowerCase());
        System.out.println(category);
        if (category == null) return new ArrayList<Product>();

        return productRepository.findByCategoryId(category.getId());
    }
}

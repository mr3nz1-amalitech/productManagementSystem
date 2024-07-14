package com.mr3nz1.productManagementSystem.repositories;

import com.mr3nz1.productManagementSystem.models.Employee;
import com.mr3nz1.productManagementSystem.models.Product;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT product FROM Product product WHERE product.categoryId = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") UUID categoryId);
}

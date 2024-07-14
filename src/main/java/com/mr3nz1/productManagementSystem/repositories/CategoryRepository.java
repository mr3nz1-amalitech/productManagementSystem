package com.mr3nz1.productManagementSystem.repositories;

import com.mr3nz1.productManagementSystem.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CategoryRepository extends MongoRepository<Category, String> {
    @Query("{ 'name' : ?0 }")
    Category findCategoryByExactName(String name);
}
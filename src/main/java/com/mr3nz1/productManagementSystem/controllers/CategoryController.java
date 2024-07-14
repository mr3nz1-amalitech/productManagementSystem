package com.mr3nz1.productManagementSystem.controllers;

import com.mr3nz1.productManagementSystem.models.Category;
import com.mr3nz1.productManagementSystem.services.CategoryService;
import com.mr3nz1.productManagementSystem.utils.BinaryTree;
import com.mr3nz1.productManagementSystem.utils.NullChecker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        if (NullChecker.check(category)) {
            return new ResponseEntity<>("Error adding category. Submit all the fields", HttpStatus.BAD_REQUEST);
        }

        categoryService.addCategory(category);

        return new ResponseEntity<>("Success adding category", HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required = false) String category) {
        List<Category> categories = categoryService.getAllCategories();

        return new ResponseEntity<>(categories, HttpStatus.OK);

    }

    @GetMapping("/categories/{category}")
    public ResponseEntity<Category> getCategory(@PathVariable String category) {
        List<Category> categories = categoryService.getAllCategories();

        BinaryTree binaryTree = new BinaryTree(categories.get(0));

        for (int i = 1; i < categories.toArray().length; i++) {
            binaryTree.insert(categories.get(i));
        }

        Category category1 = binaryTree.breadthFirstSearch(category);

        return new ResponseEntity<>(category1, HttpStatus.OK);
    }
}

package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Validated // error is bad request, not show message
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return ResponseEntity.status(HttpStatus.OK).body("get all categories with page = " + page + ", limit " + limit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCategoryById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body("get detail category information");
    }

    @PostMapping("")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO categoryDTO, BindingResult result){
        if (result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body("update category successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body("delete category successfully");
    }
}

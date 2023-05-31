package com.bootcamp.store.infrastructure.rest;

import com.bootcamp.store.application.dto.CategoryDTO;
import com.bootcamp.store.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryRestController {
    private CategoryService categoryService;
    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @CrossOrigin
    @GetMapping(value = "/categories", produces = "application/json")
    ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam(name = "partialName", required = true) String partialName) {
        List<CategoryDTO> categories;
        if (partialName == null){
             categories = this.categoryService.getAllCategories();
        }else {
            categories = categoryService.getAllCategoriesByName(partialName);
        }

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryDTO = this.categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/categories/{categoryId}")
    ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId) {
        Optional<CategoryDTO> category = this.categoryService.getCategoryById(categoryId);

        if (category.isPresent()) return new ResponseEntity<CategoryDTO>(category.get(), HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @PatchMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryUpdated = this.categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(categoryUpdated, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/categories/{categoryId}")
    ResponseEntity<?> deleteCategoryByid(@PathVariable Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

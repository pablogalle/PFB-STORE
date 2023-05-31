package com.bootcamp.store.domain.persistence;

import com.bootcamp.store.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistence {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long categoryId);
    Category saveCategory(Category category);
    void deleteCategory(Long categoryId);
    List<Category> getCategoriesByName(String partialName);
}

package com.bootcamp.store.application.mapper;

import com.bootcamp.store.application.dto.CategoryDTO;
import com.bootcamp.store.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {
    default Category fromId(Long id){
        if (id == null) return null;

        Category category = new Category();
        category.setId(id);
        return category;
    }
}

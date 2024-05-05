package com.khabalita.springboot.mapper;

import com.khabalita.springboot.dto.CategoryDTO;
import com.khabalita.springboot.entities.Category;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class CategoryMapper {

    @Autowired
    ModelMapper modelMapper;

    public Category categoryDTOtoCategory(CategoryDTO categoryDTO){
        Category category = modelMapper.map(categoryDTO, Category.class);
        return category;
    }

    public CategoryDTO categoryToCategoryDTO(Category category){
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }
}

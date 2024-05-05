package com.khabalita.springboot.service;

import com.khabalita.springboot.dto.CategoryDTO;
import com.khabalita.springboot.entities.Category;
import com.khabalita.springboot.mapper.CategoryMapper;
import com.khabalita.springboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public Category newCategory(CategoryDTO categoryDTO) throws Exception{
        try{
            Category category = categoryMapper.categoryDTOtoCategory(categoryDTO);
            Category categorySaved = categoryRepository.save(category);
            return categorySaved;
        }catch(Exception e){
            throw new Exception("No se pudo crear una categoria" + e.getMessage());
        }
    }

    public List<CategoryDTO> listAllCategories() throws Exception{
        try{
            List<Category> categories = categoryRepository.findAll();
            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            for(Category category: categories){
                categoryDTOList.add(categoryMapper.categoryToCategoryDTO(category));
            }
            return categoryDTOList;
        }catch(Exception e){
            throw new Exception ("No se pudo devolver la lista de categorias" + e.getMessage());
        }
    }

    public CategoryDTO updateCategory(Long id, CategoryDTO CategoryDTO) throws Exception {
        try{
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de categoria no encontrado: " + id));
            categoryMapper.categoryToCategoryDTO(category);
            Category updatedCategory = categoryRepository.save(category);
            return categoryMapper.categoryToCategoryDTO(updatedCategory);
        }catch(Exception e){
            throw new Exception ("No se pudo actualizar la categoria" + e.getMessage());
        }
    }

    public void deleteCategory(Long id) throws Exception{
        try{
            categoryRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception ("No se pudo eliminar la categoria" + e.getMessage());
        }
    }

    public CategoryDTO findCategryById(Long id) throws Exception{
        try{
            Category category = categoryRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de categoria no encontrado " + id));
            return categoryMapper.categoryToCategoryDTO(category);
        }catch (Exception e){
            throw new Exception("No se pudo traer la categoria" + e.getMessage());
        }
    }

    public List<Category> findByName(String name) throws Exception {
        return List.of();
    }
}

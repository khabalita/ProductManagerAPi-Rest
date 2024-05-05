package com.khabalita.springboot.repository;

import com.khabalita.springboot.entities.Brand;
import com.khabalita.springboot.entities.Category;
import com.khabalita.springboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name) throws Exception;

    List<Product> findByBrand(Brand brand) throws Exception;

    List<Product> findByCategory(Category category) throws Exception;

}

package com.khabalita.springboot.service;

import com.khabalita.springboot.dto.ProductDTO;
import com.khabalita.springboot.entities.Brand;
import com.khabalita.springboot.entities.Category;
import com.khabalita.springboot.entities.Product;
import com.khabalita.springboot.mapper.ProductMapper;
import com.khabalita.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService{
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    public Product newProduct(ProductDTO productDTO) throws Exception{
        try{
            Product product = productMapper.productDTOToProduct(productDTO);
            Product productSaved = productRepository.save(product);
            return productSaved;
        }catch(Exception e){
            throw new Exception ("El producto no fue creado" +  e.getMessage());
        }
    }

    public List<ProductDTO> listAllProducts() throws Exception{
        try{
            List<Product> products = productRepository.findAll();
            List<ProductDTO> productDTOList = new ArrayList<>();
            for(Product product: products){
                productDTOList.add(productMapper.ProductToProductDTO(product));
            }
            return productDTOList;
        }catch(Exception e){
            throw new Exception ("No se puede devolver la lista" + e.getMessage());
        }
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) throws Exception {
        try{
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de producto no encontrado: " + id));
            productMapper.productDTOToProduct(productDTO);
            Product updatedProduct = productRepository.save(product);
            return productMapper.ProductToProductDTO(updatedProduct);
        }catch(Exception e){
            throw new Exception ("No se pudo actualizar el producto" + e.getMessage());
        }
    }

    public void deleteProduct(Long id) throws Exception{
        try{
            productRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception ("No se pudo eliminar el producto" + e.getMessage());
        }
    }

    public ProductDTO findProductById(Long id) throws Exception{
        try{
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de producto no encontrado " + id));
            return productMapper.ProductToProductDTO(product);
        }catch (Exception e){
            throw new Exception("No se pudo traer el producto" + e.getMessage());
        }
    }

    public List<ProductDTO> getAllProductsByName(String name) throws Exception {
        try{
            List<Product> products = productRepository.findByName(name);
            List<ProductDTO> productsDTOList = new ArrayList<>();
            for(Product product : products){
                productsDTOList.add(productMapper.ProductToProductDTO(product));
            }
            return productsDTOList;
        }catch(Exception e){
            throw new Exception("No se pudo devolver la lista de productos" + e.getMessage());
        }

    }

    public List<ProductDTO> getAllProductsByBrand(Brand brand) throws Exception{
        try{
            List<Product> products = productRepository.findByBrand(brand);
            List<ProductDTO> productsDTOList = new ArrayList<>();
            for(Product product : products){
                productsDTOList.add(productMapper.ProductToProductDTO(product));
            }
            return productsDTOList;
        }catch(Exception e){
            throw new Exception("No se pudo devolver la lista de productos" + e.getMessage());
        }
    }

    public List<ProductDTO> getAllProductsByCategory(Category category) throws Exception{
        try{
            List<Product> products = productRepository.findByCategory(category);
            List<ProductDTO> productsDTOList = new ArrayList<>();
            for(Product product : products){
                productsDTOList.add(productMapper.ProductToProductDTO(product));
            }
            return productsDTOList;
        }catch(Exception e){
            throw new Exception("No se pudo devolver la lista de productos por categoria" + e.getMessage());
        }
    }

}

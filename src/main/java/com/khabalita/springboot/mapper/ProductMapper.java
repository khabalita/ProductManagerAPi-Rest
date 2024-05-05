package com.khabalita.springboot.mapper;

import com.khabalita.springboot.dto.ProductDTO;
import com.khabalita.springboot.entities.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Product productDTOToProduct(ProductDTO productDTO){
        Product product = modelMapper.map(productDTO, Product.class);
        return product;
    }

    public ProductDTO ProductToProductDTO(Product product){
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }
}

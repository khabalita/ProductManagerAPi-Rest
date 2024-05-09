package com.khabalita.springboot.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String code;
    private BrandDTO brandDTO;
    private CategoryDTO categoryDTO;

}

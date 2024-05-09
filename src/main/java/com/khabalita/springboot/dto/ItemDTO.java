package com.khabalita.springboot.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private int quantity;
    private ProductDTO productDTO;
}

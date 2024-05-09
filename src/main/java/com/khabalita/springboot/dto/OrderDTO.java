package com.khabalita.springboot.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private LocalDate startTime;
    private String state;
    private List<ItemDTO> itemsDTO;
}

package com.khabalita.springboot.mapper;

import com.khabalita.springboot.dto.BrandDTO;
import com.khabalita.springboot.entities.Brand;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class BrandMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Brand brandDTOToBrand(BrandDTO brandDTO){
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        return brand;
    }

    public BrandDTO brandToBrandDTO(Brand brand){
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);
        return brandDTO;
    }
}

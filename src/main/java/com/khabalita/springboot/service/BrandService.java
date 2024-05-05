package com.khabalita.springboot.service;

import com.khabalita.springboot.dto.BrandDTO;
import com.khabalita.springboot.entities.Brand;
import com.khabalita.springboot.mapper.BrandMapper;
import com.khabalita.springboot.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandMapper brandMapper;

    public Brand newBrand(BrandDTO brandDTO) throws Exception{
        try{
            Brand brand= brandMapper.brandDTOToBrand(brandDTO);
            Brand brandSaved = brandRepository.save(brand);
            return brandSaved;
        }catch(Exception e){
            throw new Exception("No se pudo crear una marca" + e.getMessage());
        }
    }

    public List<BrandDTO> listAllBrands() throws Exception{
        try{
            List<Brand> brandList = brandRepository.findAll();
            List<BrandDTO> brandDTOList = new ArrayList<>();
            for(Brand brand: brandList){
                brandDTOList.add(brandMapper.brandToBrandDTO(brand));
            }
            return brandDTOList;
        }catch(Exception e){
            throw new Exception ("No se pudo devolver la lista de marcas" + e.getMessage());
        }
    }

    public BrandDTO updateBrand(Long id, BrandDTO BrandDTO) throws Exception {
        try{
            Brand brand= brandRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de marca no encontrado: " + id));
            brandMapper.brandToBrandDTO(brand);
            Brand updatedBrand = brandRepository.save(brand);
            return brandMapper.brandToBrandDTO(updatedBrand);
        }catch(Exception e){
            throw new Exception ("No se pudo actualizar la marca" + e.getMessage());
        }
    }

    public void deleteBrand(Long id) throws Exception{
        try{
            brandRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception ("No se pudo eliminar la marca" + e.getMessage());
        }
    }

    public BrandDTO findbrandById(Long id) throws Exception{
        try{
            Brand brand = brandRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de la marca no encontrado" + id));
            return brandMapper.brandToBrandDTO(brand);
        }catch (Exception e){
            throw new Exception("No se pudo traer la marca" + e.getMessage());
        }
    }
}

package com.khabalita.springboot.mapper;

import com.khabalita.springboot.dto.ItemDTO;
import com.khabalita.springboot.entities.Item;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Item itemDTOToItem(ItemDTO itemDTO){
        Item item = modelMapper.map(itemDTO, Item.class);
        return item;
    }

    public ItemDTO ItemToItemDTO(Item item){
        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
        return itemDTO;
    }
}

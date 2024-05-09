package com.khabalita.springboot.service;

import com.khabalita.springboot.dto.ItemDTO;
import com.khabalita.springboot.entities.Item;
import com.khabalita.springboot.mapper.ItemMapper;
import com.khabalita.springboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemMapper itemMapper;

    public Item newItem(ItemDTO itemDto) throws Exception{
        try{
            Item item = itemMapper.itemDTOToItem(itemDto);
            Item itemSaved = itemRepository.save(item);
            return itemSaved;
        }catch(Exception e){
            throw new Exception ("El item no fue creado" + e.getMessage());
        }
    }

    public List<ItemDTO> listAllItems() throws Exception{
        try{
            List<Item> items = itemRepository.findAll();
            List<ItemDTO> itemsDTOList = new ArrayList<>();
            for(Item item: items){
                itemsDTOList.add(itemMapper.ItemToItemDTO(item));
            }
            return itemsDTOList;
        }catch(Exception e){
            throw new Exception ("No se pudo devolver la lista" + e.getMessage());
        }
    }

    public ItemDTO updateItem(Long id, ItemDTO itemDTO) throws Exception{
        try{
            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de item no encontrado" + id));
            itemMapper.itemDTOToItem(itemDTO);
            Item updatedItem = itemRepository.save(item);
            return itemMapper.ItemToItemDTO(updatedItem);
        }catch(Exception e){
            throw new Exception ("No se pudo actualizar el item" + e.getMessage());
        }
    }

    public void deleteItem(Long id) throws Exception{
        try{
            itemRepository.deleteById(id);
        }catch(Exception e){
            throw new Exception ("no se pudo eliminar el producto" + e.getMessage());
        }
    }

    public ItemDTO findItemById(Long id) throws Exception{
        try{
            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new Exception("ID de item no encontrado" + id));
            return itemMapper.ItemToItemDTO(item);
        }catch(Exception e){
            throw new Exception ("No se pudo traer el Item" + e.getMessage());
        }
    }
}

package com.khabalita.springboot.repository;

import com.khabalita.springboot.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

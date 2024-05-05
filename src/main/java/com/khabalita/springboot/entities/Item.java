package com.khabalita.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "items")
@Data
public class Item extends Base{

    @Column(name = "subTotal")
    private Double subTotal;
    @Column(name = "quantity")
    private int quantity;
    @OneToOne
    @Column(name = "product_id")
    private Product product;
}

package com.khabalita.springboot.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product extends Base{

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "code")
    private String code;
    @OneToOne
    @Column(name = "category")
    private Category category;
    @OneToOne
    @Column(name = "brand")
    private Brand brand;
}

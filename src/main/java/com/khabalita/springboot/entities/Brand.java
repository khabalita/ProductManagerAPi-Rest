package com.khabalita.springboot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "brand")
@Data
public class Brand extends Base{

    @Column(name = "name")
    private String name;
}

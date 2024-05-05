package com.khabalita.springboot.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categories")
@Data
public class Category extends Base{

    @Column(name = "name")
    private String name;
}

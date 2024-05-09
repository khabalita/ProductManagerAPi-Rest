package com.khabalita.springboot.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "Orders")
@Data
public class Order extends Base{
    @Column(name = "startTime")
    private LocalDate startTime;
    @Column(name = "state")
    private String state;
    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Item> items;
}

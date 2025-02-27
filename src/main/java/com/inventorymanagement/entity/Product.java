package com.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "unit")
    private String unit;
    @Column(name = "sellingPrice")
    private Double sellingPrice;
    @Column(name = "categoryCode")
    private String categoryCode;
    @Column(name = "brandCode")
    private String brandCoded;
    @Column(name = "createAt")
    private LocalDateTime createAt;
}

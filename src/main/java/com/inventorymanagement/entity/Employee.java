package com.inventorymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "roleCode")
    private String roleCode;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "inventoryCode")
    private String inventoryCode;
    @Column(name = "createAt")
    private LocalDateTime createAt;
    @Column(name = "isBlock")
    private Boolean isBlock;
}

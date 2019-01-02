package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String name;
    private Long price;


}

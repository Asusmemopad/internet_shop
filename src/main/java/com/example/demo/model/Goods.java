package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
public class Goods {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "goods code is required")
    @Size(min = 4, message = "please use minimum 4 characters")
    @Column(updatable = false, unique = true)
    private String code;
    @NotBlank(message = "goods name is required")
    private String name;
    private Long price;
}

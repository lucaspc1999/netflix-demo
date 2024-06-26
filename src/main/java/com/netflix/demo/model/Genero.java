package com.netflix.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_genero")
public class Genero implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @NotEmpty
    private String titulo;
}

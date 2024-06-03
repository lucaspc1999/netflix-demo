package com.netflix.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @NotEmpty
    private String titulo;

    @Min(0)
    @Max(18)
    private int classe_indicativa;

    @NotEmpty
    private String diretor;

    @NotEmpty
    private String idioma;

    @NotEmpty
    private String legenda;

    @Min(1888) // Assuming movies started being produced around this year
    private int ano;

    @Min(0)
    public int min_atual;

    @Size(max = 500)
    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;
}

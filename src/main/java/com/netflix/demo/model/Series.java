package com.netflix.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_series")
public class Series implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @NotEmpty
    private String titulo;

    @Min(0)
    @Max(18)
    private Integer classe_indicativa;

    @NotEmpty
    private String diretor;

    @NotEmpty
    private String idiomas;

    @NotEmpty
    private String legendas;

    @Min(1)
    private int episodios;

    @Min(0)
    public int min_atual;

    @Size(max = 500)
    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;
}

package com.netflix.demo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    private String titulo;
    private int classe_indicativa;
    private String diretor;
    private String idioma;
    private String legenda;
    private int ano;

    //dado em segundos
    public int min_atual;

    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;

}
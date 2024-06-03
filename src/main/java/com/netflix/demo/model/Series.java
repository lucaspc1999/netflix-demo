package com.netflix.demo.model;

import jakarta.persistence.*;
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
    private String titulo;
    private Integer classe_indicativa;
    private String diretor;
    private String idiomas;
    private String legendas;
    private int episodios;

    //dado em segundos
    public int min_atual;

    @Column(name = "ds_sinopse", length = 500)
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;

}

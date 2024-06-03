package com.netflix.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_favorito")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "filme_id", referencedColumnName = "id")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Series serie;
}

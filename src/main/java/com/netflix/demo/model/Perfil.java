package com.netflix.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_perfil")
public class Perfil {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @NotEmpty
    private String nome;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
}

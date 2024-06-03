package com.netflix.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    private String nome;

    @Column(length = 11)
    private String numero;

    @Column(length = 11)
    private Integer cpf;

    @NotNull
    @Column(unique = true)
    private String login;

    @Email
    @NotEmpty
    private String email;

    @NotNull
    private Date data_nasc;

    @NotNull
    private String senha;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

}

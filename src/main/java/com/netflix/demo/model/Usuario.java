package com.netflix.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @NotEmpty
    private String nome;

    @Size(min = 11, max = 11)
    @NotEmpty
    @Column(length = 11)
    private String numero;

    @NotNull
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

    @NotEmpty
    private String senha;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
}

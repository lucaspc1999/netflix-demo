package com.netflix.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Cartao {
    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @Size(min = 16, max = 16)
    private String numeroCartao;

    @NotEmpty
    @Size(min = 5, max = 5)
    private String validadeCartao;

    @NotEmpty
    @Size(min = 3, max = 3)
    private String codigoSeguranca;

    @NotEmpty
    private String nomeTitularCartao;
}

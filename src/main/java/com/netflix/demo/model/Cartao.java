package com.netflix.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cartao {
    @Id
    @GeneratedValue
    private int id;
    private String numeroCartao;
    private String validadeCartao;
    private String codigoSeguranca;
    private String nomeTitularCartao;

}

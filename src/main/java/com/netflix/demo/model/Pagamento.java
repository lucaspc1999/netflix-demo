package com.netflix.demo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table (name = "tb_pagamento")
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;
    private String pix;
    private Date data_venc;
    private String gift_card;

    @OneToOne
    @JoinColumn(name = "cartao_id", referencedColumnName = "id")
    private Cartao cartao;

    @OneToOne
    @JoinColumn(name = "boleto_id", referencedColumnName = "id")
    private Boleto boleto;
}

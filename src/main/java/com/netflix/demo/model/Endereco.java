package com.netflix.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table (name ="tb_Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    //coluna para que seja descrito o endereço (rua, numero, etc.)
    @Column(name = "ds_endereco", length = 500)
    private String endereco;
}


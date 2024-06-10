package com.vidal.dicyane.filme_unifacisa_backend.domain;


import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
public class Filme implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String diretor;
    private String genero;
    private Integer anoLancamento;
    private Double duracao;

}
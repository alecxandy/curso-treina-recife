package com.treina.treina.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Table(name = "tb_lead")
public class Lead {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 45)
    private String nome;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "dt_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "dt_novoContato")
    private LocalDate dataNovoContato;

    @Column(name = "observacao",length = 45)
    private String observacao;


}

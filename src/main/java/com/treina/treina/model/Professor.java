package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 45)
    private String nome;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "vrHoraAula")
    private float valorHoraAula;



    @OneToMany
    @JoinColumn(name = "turma_id")
    private List<Turma> turmaList;
     

}

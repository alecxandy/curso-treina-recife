package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_curso", length = 45)
    private String nomeCurso;

    @Column(name = "ch_aula")
    private float chaula;

    @Column(name = "ch_total")
    private float chTotal;

    @Column(name = "turno", length = 20)
    private String turno;

    @Column(name = "valor")
    private float valor;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmaList;

}

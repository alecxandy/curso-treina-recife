package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long id_aluno;

    private Long id_curso;

    private Long id_professor;

    private Float valor;

    private boolean segunda;

    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;

    @OneToMany(mappedBy = "turmaList")
    private List<Aluno> alunoList;
    

    @OneToMany
    @JoinColumn(name = "turma_id")
    private List<Turma> turmaList;


}

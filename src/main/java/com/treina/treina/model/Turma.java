package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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

    @Column(name = "valor")
    private Float valor;

    private Boolean segunda;
    private Boolean terca;
    private Boolean quarta;
    private Boolean quinta;
    private Boolean sexta;
    private Boolean sabado;
    private Boolean domingo;
    @ManyToMany
    @JoinTable(name = "tb_turma_has_aluno",
            joinColumns = {@JoinColumn(name = "turma_id_fk")},
            inverseJoinColumns = {@JoinColumn(name = "aluno_id_fk")})
    private Set<Aluno> alunoList;

    @JoinColumn(name = "professor_id")
    @OneToOne
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "curso_id_fk")
    private Curso curso;

}

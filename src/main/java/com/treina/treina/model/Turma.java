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

    @Column(name = "valor")
    private Float valor;

    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;

    @ManyToMany
    @JoinTable(name = "turma_has_aluno",
            joinColumns = {@JoinColumn(name = "turma_id_fk")},
            inverseJoinColumns = {@JoinColumn(name = "aluno_id_fk")})
    private List<Aluno> alunoList;

    @OneToOne(mappedBy  = "turma")
    private Professor professor;


}

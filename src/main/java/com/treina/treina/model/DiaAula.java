package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_diaAula")
public class DiaAula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dt_aula")
    private LocalDate dataAula;

    @OneToMany(mappedBy = "diaAula")
    private List<Turma> turmaList;
}

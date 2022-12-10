package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tb_diaAula")
public class DiaAula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dt_aula")
    private LocalDateTime dataAula;
/*
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "turma_id_fk")
    private Turma turma;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sala_id_fk")
    private Sala sala;

}

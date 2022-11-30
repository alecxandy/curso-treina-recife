package com.treina.treina.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "tb_diaAula")
public class DiaAula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dt_data")
    private LocalDateTime localDateTime;

    @OneToOne
    @JoinColumn(name = "turma_id_fk")
    private Turma turma;

    @OneToOne
    @JoinColumn(name = "sala_id_fk")
    private Sala sala;
}

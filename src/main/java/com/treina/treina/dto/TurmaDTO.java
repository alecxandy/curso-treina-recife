package com.treina.treina.dto;

import com.treina.treina.model.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {

    private Long id;
    private Float valor;
    private boolean domingo;
    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private Long professor_id;
    private Long curso_id;
    private Long diaAula_id;
    private List<Turma> turmaList;
}

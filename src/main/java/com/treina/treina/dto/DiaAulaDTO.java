package com.treina.treina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaAulaDTO {

    private LocalDateTime localDateTime;
    private Long sala_id;
    private Long turma_id;
}

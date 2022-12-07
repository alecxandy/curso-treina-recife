package com.treina.treina.service;

import com.treina.treina.dto.DiaAulaDTO;
import com.treina.treina.model.DiaAula;
import com.treina.treina.model.Sala;
import com.treina.treina.model.Turma;
import com.treina.treina.repository.DiaaulaRepository;
import com.treina.treina.repository.SalaRepository;
import com.treina.treina.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DiaAulaService {

    @Autowired
    private DiaaulaRepository diaaulaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private SalaRepository salaRepository;

    public DiaAula save(DiaAulaDTO diaAulaDTO) {

        Sala sala = salaRepository.findById(diaAulaDTO.getSala_id())
                .orElseThrow(() -> new RuntimeException("Id is not exists"));

        Turma turma = turmaRepository.findById(diaAulaDTO.getTurma_id())
                .orElseThrow(() -> new RuntimeException("Id is not exists"));

        DiaAula diaAula = new DiaAula();

        diaAula.setDataAula(LocalDateTime.now());
        diaAula.setTurma(turma);
        diaAula.setSala(sala);

        return diaaulaRepository.save(diaAula);
    }
}

package com.treina.treina.service;

import com.treina.treina.dto.TurmaDTO;
import com.treina.treina.model.Curso;
import com.treina.treina.model.DiaAula;
import com.treina.treina.model.Professor;
import com.treina.treina.model.Turma;
import com.treina.treina.repository.CursoRepository;
import com.treina.treina.repository.DiaaulaRepository;
import com.treina.treina.repository.ProfessorRepository;
import com.treina.treina.repository.TurmaRepository;
import org.hibernate.loader.plan.spi.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private DiaaulaRepository diaaulaRepository;

    public Turma save(TurmaDTO turmaDTO) {
        Curso curso = cursoRepository.findById(turmaDTO.getCurso_id())
                .orElseThrow(() -> new RuntimeException("id is not exists"));
        Professor professor = professorRepository.findById(turmaDTO.getProfessor_id())
                .orElseThrow(() -> new RuntimeException("id is not exists"));
//        DiaAula diaAula = diaaulaRepository.findById(turmaDTO.getDiaAula_id())
//                .orElseThrow(() -> new RuntimeException("id is not exists"));

        Turma turma = new Turma();

        turma.setCurso(curso);
        //  turma.setDiaAula(diaAula);
        turma.setProfessor(professor);
        turma.setValor(turmaDTO.getValor());
        turma.setDomingo(turmaDTO.isDomingo());
        turma.setDomingo(turmaDTO.isSegunda());
        turma.setDomingo(turmaDTO.isTerca());
        turma.setDomingo(turmaDTO.isQuarta());
        turma.setDomingo(turmaDTO.isQuinta());
        turma.setDomingo(turmaDTO.isSexta());
        turma.setDomingo(turmaDTO.isSabado());
        turmaRepository.save(turma);
        return turma;
    }

    public List<Turma> listAll() {
        return turmaRepository.findAll();
    }

}

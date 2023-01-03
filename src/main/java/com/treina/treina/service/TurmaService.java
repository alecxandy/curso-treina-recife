package com.treina.treina.service;

import com.treina.treina.dto.TurmaDTO;
import com.treina.treina.exception.BadRequestException;
import com.treina.treina.model.*;
import com.treina.treina.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private DiaaulaRepository diaaulaRepository;

    public Turma save(TurmaDTO turmaDTO) {
        Curso curso = cursoRepository.findById(turmaDTO.getCurso_id())
                .orElseThrow(() -> new BadRequestException("id is not exists"));
        Professor professor = professorRepository.findById(turmaDTO.getProfessor_id())
                .orElseThrow(() -> new BadRequestException("id is not exists"));
        DiaAula diaAula = diaaulaRepository.findById(turmaDTO.getDiaAula_id())
                .orElseThrow(() -> new BadRequestException("id is not exists"));

        Turma turma = new Turma();
        turma.setAlunoList(transfomar(turmaDTO.getAlunoList()));
        turma.setCurso(curso);
        turma.setProfessor(professor);
        turma.setDiaAula(diaAula);
        turma.setValor(turmaDTO.getValor());
        turma.setDomingo(turmaDTO.getDomingo());
        turma.setSegunda(turmaDTO.getSegunda());
        turma.setTerca(turmaDTO.getTerca());
        turma.setQuarta(turmaDTO.getQuarta());
        turma.setQuinta(turmaDTO.getQuinta());
        turma.setSexta(turmaDTO.getSexta());
        turma.setSabado(turmaDTO.getSabado());
        turmaRepository.save(turma);
        return turma;
    }

    public Page<Turma> listAll() {
        Pageable pageable = PageRequest.of(0,10);
        return turmaRepository.findAll(pageable);
    }

    public Optional<Turma> findById(Long id) {
        return turmaRepository.findById(id);
    }

    public void deleteById(Long id) {
        turmaRepository.deleteById(id);
    }

    public Turma update(Turma turma) {
        return turmaRepository.save(turma);
    }


    //Metodo que trasforma uma lista de inteiro em uma lista de Alunos
    public Set<Aluno> transfomar(Set<Long> longList) {
        Set<Aluno> alunoList = new HashSet<>();
        longList.forEach(e -> {
            Aluno aluno = alunoRepository.findById(e).orElseThrow(() -> new BadRequestException("ID is not existes"));
            alunoList.add(aluno);
        });
        return alunoList;
    }

}

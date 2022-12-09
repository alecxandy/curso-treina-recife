package com.treina.treina.service;

import com.treina.treina.dto.TurmaDTO;
import com.treina.treina.model.*;
import com.treina.treina.repository.AlunoRepository;
import com.treina.treina.repository.CursoRepository;
import com.treina.treina.repository.ProfessorRepository;
import com.treina.treina.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Turma save(TurmaDTO turmaDTO) {
        Curso curso = cursoRepository.findById(turmaDTO.getCurso_id())
                .orElseThrow(() -> new RuntimeException("id is not exists"));
        Professor professor = professorRepository.findById(turmaDTO.getProfessor_id())
                .orElseThrow(() -> new RuntimeException("id is not exists"));

        Turma turma = new Turma();
        turma.setAlunoList(transfomar(turmaDTO.getAlunoList()));
        turma.setCurso(curso);
        turma.setProfessor(professor);
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

    public List<Turma> listAll() {
        return turmaRepository.findAll();
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
        longList.stream().forEach(e -> {
            Aluno aluno = alunoRepository.findById(e).orElseThrow(() -> new RuntimeException("Id is not existes"));
            alunoList.add(aluno);
        });
        return alunoList;
    }

}

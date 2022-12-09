package com.treina.treina.controller;


import com.treina.treina.dto.TurmaDTO;
import com.treina.treina.model.Turma;
import com.treina.treina.repository.DiaaulaRepository;
import com.treina.treina.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private DiaaulaRepository diaaulaRepository;

    @PostMapping("/")
    public ResponseEntity<Turma> save(@RequestBody TurmaDTO turmaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turmaDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<Turma>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.listAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turma>> findById(@PathVariable Long id) {
        Optional<Turma> optionalSala = turmaService.findById(id);
        if (optionalSala.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalSala);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Turma> optionalTurma = turmaService.findById(id);
        if (optionalTurma.isPresent()) {
            //tem que excluir diaAula que tem o id de turma tambem
            //diaaulaRepository.deletarTurma(id);
            turmaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Delete successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO) {
        Optional<Turma> optionalSala = turmaService.findById(id);
        if (optionalSala.isPresent()) {
            TurmaDTO t = new TurmaDTO();
            t.setId(id);
            t.setAlunoList(turmaDTO.getAlunoList());
            t.setProfessor_id(turmaDTO.getProfessor_id());
            t.setValor(turmaDTO.getValor());
            t.setCurso_id(turmaDTO.getCurso_id());
            t.setDomingo(turmaDTO.getDomingo());
            t.setSegunda(turmaDTO.getSegunda());
            t.setTerca(turmaDTO.getTerca());
            t.setQuarta(turmaDTO.getQuarta());
            t.setQuinta(turmaDTO.getQuinta());
            t.setSexta(turmaDTO.getSexta());
            t.setSabado(turmaDTO.getSabado());
            return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(t));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

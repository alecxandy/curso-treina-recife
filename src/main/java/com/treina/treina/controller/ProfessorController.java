package com.treina.treina.controller;

import com.treina.treina.model.Professor;
import com.treina.treina.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;


    @PostMapping("/")
    public ResponseEntity<Professor> save(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorRepository.save(professor));
    }

    @GetMapping("/")
    public ResponseEntity<List<Professor>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            professorRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is not exist");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Professor>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Professor>> findByNomeContains(
            @RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findByNomeContains(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor professor) {
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if (professorOptional.isPresent()) {
            Professor prof = new Professor();
            prof.setId(id);
            prof.setNome(professor.getNome());
            prof.setTelefone(professor.getTelefone());
            prof.setValorHoraAula(professor.getValorHoraAula());
            return ResponseEntity.status(HttpStatus.OK).body(professorRepository.save(prof));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

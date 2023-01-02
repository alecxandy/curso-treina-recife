package com.treina.treina.controller;

import com.treina.treina.model.Aluno;
import com.treina.treina.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
public class ALunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/")
    public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Aluno>> listAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluno>> findById(@PathVariable Long id) {

        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Id is not exists"));


                Optional < Aluno > optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalAluno);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não localizado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            Aluno al = new Aluno();
            al.setId(id);
            al.setNome(aluno.getNome());
            al.setCpf(aluno.getCpf());
            al.setEndereco(aluno.getEndereco());
            al.setTelefone(aluno.getTelefone());
            return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(al));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Aluno>> findByNomeContains(
            @RequestParam(value = "nome", required = false) String nome) {
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findByNomeContains(nome));
    }


}









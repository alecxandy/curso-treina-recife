package com.treina.treina.controller;

import com.treina.treina.model.Curso;
import com.treina.treina.repository.CursoRepository;
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
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;


    @PostMapping("/")
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoRepository.save(curso));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Curso>> listAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            cursoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is not exist");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isPresent()) {
            Curso curs = new Curso();
            curs.setId(id);
            curs.setNomeCurso(curso.getNomeCurso());
            curs.setChaula(curso.getChaula());
            curs.setChTotal(curso.getChTotal());
            curs.setTurno(curso.getTurno());
            curs.setValor(curso.getValor());
            return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.save(curs));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

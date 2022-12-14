package com.treina.treina.controller;

import com.treina.treina.model.Sala;
import com.treina.treina.repository.SalaRepository;
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
@RequestMapping("/api/sala")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    @PostMapping("/")
    public ResponseEntity<Sala> save(@RequestBody Sala sala) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaRepository.save(sala));
    }

    @GetMapping("/")
    public ResponseEntity<Page<Sala>> listAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return ResponseEntity.status(HttpStatus.OK).body(salaRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Sala>> findById(@PathVariable Long id) {
        Optional<Sala> optionalSala = salaRepository.findById(id);
        if (optionalSala.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalSala);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Sala> optionalSala = salaRepository.findById(id);
        if (optionalSala.isPresent()) {
            salaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não localizado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> update(@PathVariable Long id, @RequestBody Sala sala) {
        Optional<Sala> optionalSala = salaRepository.findById(id);
        if (optionalSala.isPresent()) {
            Sala s = new Sala();
            s.setId(id);
            s.setNome(sala.getNome());
            return ResponseEntity.status(HttpStatus.OK).body(salaRepository.save(s));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
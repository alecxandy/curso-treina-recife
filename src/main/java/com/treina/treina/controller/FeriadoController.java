package com.treina.treina.controller;

import com.treina.treina.model.Curso;
import com.treina.treina.model.Feriado;
import com.treina.treina.repository.CursoRepository;
import com.treina.treina.repository.FeriadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feriados")
public class FeriadoController {


    @Autowired
    private FeriadoRepository feriadoRepository;


    @PostMapping("/")
    public ResponseEntity<Feriado> save(@RequestBody Feriado feriado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feriadoRepository.save(feriado));
    }

    @GetMapping("/")
    public ResponseEntity<List<Feriado>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(feriadoRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Feriado> feriadoOptional = feriadoRepository.findById(id);
        if (feriadoOptional.isPresent()) {
            feriadoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is not exist");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Feriado>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(feriadoRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feriado> update(@PathVariable Long id, @RequestBody Feriado feriado) {
        Optional<Feriado> feriadoOptional = feriadoRepository.findById(id);
        if (feriadoOptional.isPresent()) {
            Feriado f = new Feriado();
            f.setId(id);
            f.setDataFeriado(feriado.getDataFeriado());
            f.setDescricao(feriado.getDescricao());
            return ResponseEntity.status(HttpStatus.OK).body(feriadoRepository.save(f));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

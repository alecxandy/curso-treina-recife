package com.treina.treina.controller;

import com.treina.treina.dto.DiaAulaDTO;
import com.treina.treina.model.DiaAula;
import com.treina.treina.repository.DiaaulaRepository;
import com.treina.treina.service.DiaAulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/diaaulas")
public class DiaAulaController {


    @Autowired
    private DiaAulaService diaAulaService;

    @Autowired
    private DiaaulaRepository diaaulaRepository;


    @PostMapping("/")
    public ResponseEntity<DiaAula> save(@RequestBody DiaAulaDTO diaAulaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diaAulaService.save(diaAulaDTO));
    }

    @GetMapping("/")
    public ResponseEntity<Page<DiaAula>> listAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return ResponseEntity.status(HttpStatus.OK).body(diaaulaRepository.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<DiaAula> diaAulaOptional = diaaulaRepository.findById(id);
        if (diaAulaOptional.isPresent()) {
            diaaulaRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID is not exist");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DiaAula>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(diaaulaRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaAula> update(@PathVariable Long id, @RequestBody DiaAula diaAula) {
        Optional<DiaAula> diaAulaOptional = diaaulaRepository.findById(id);
        if (diaAulaOptional.isPresent()) {
            DiaAula d = new DiaAula();
            d.setId(id);
            d.setDataAula(diaAula.getDataAula());
            d.setSala(diaAula.getSala());
            d.setDataAula(LocalDateTime.now());
            return ResponseEntity.status(HttpStatus.OK).body(diaaulaRepository.save(d));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

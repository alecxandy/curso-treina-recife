package com.treina.treina.controller;


import com.treina.treina.dto.TurmaDTO;
import com.treina.treina.model.Turma;
import com.treina.treina.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;


    @PostMapping("/")
    public ResponseEntity<Turma> save(@RequestBody TurmaDTO turmaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turmaDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<Turma>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.listAll());
    }


}

package com.treina.treina.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treina.treina.model.Lead;
import com.treina.treina.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadController {


    @Autowired
    private LeadRepository leadRepository;


    @PostMapping("/")
    public ResponseEntity<Lead> save(@RequestBody Lead lead) {
        lead.setDataCadastro(LocalDate.now());
        lead.setDataNovoContato(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(leadRepository.save(lead));

    }

    @GetMapping("/")
    public ResponseEntity<Page<Lead>> listAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return ResponseEntity.status(HttpStatus.OK).body(leadRepository.findAll(pageable));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Lead>> delete(@PathVariable Long id) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent()) {
            leadRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();

        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Lead>> findById(@PathVariable Long id) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(optionalLead);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Lead> update(@PathVariable Long id, @RequestBody Lead lead) {
        Optional<Lead> optionalLead = leadRepository.findById(id);
        if (optionalLead.isPresent()) {
            Lead c = new Lead();
            c.setId(id);
            c.setNome(lead.getNome());
            c.setTelefone(lead.getTelefone());
            c.setDataCadastro(lead.getDataNovoContato());
            c.setStatus(lead.getStatus());
            c.setDataNovoContato(lead.getDataNovoContato());
            c.setObservacao(lead.getObservacao());
            return ResponseEntity.status(HttpStatus.OK).body(leadRepository.save(c));

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }


}

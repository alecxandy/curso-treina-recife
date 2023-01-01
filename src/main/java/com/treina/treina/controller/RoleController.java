package com.treina.treina.controller;

import com.treina.treina.model.Role;
import com.treina.treina.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;


    @PostMapping("/")
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleRepository.save(role));
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    public ResponseEntity<List<Role>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Role>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(roleRepository.findById(id));
    }


}

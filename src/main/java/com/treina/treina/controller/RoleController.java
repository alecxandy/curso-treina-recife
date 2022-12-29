package com.treina.treina.controller;

import com.treina.treina.model.Role;
import com.treina.treina.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/role/save")
    public Role save(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @GetMapping("/role/listAll")
    public List<Role> listAll() {
        return roleRepository.findAll();
    }

    @GetMapping("/role/{uuid}")
    public Optional<Role> findById(@PathVariable Long id) {
        return roleRepository.findById(id);
    }

}

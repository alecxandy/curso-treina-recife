package com.treina.treina.controller;

import com.treina.treina.dto.UsuarioDTO;
import com.treina.treina.model.Role;
import com.treina.treina.model.Usuario;
import com.treina.treina.repository.RoleRepository;
import com.treina.treina.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;


    @PostMapping("/")
    public ResponseEntity<Usuario> save(@RequestBody UsuarioDTO usuarioDTO) {
        List<Role> roleList = new ArrayList<>();
        usuarioDTO.getRoleList().forEach(e -> {
            Role role = roleRepository.findById(e)
                    .orElseThrow(() -> new RuntimeException("Role não existe"));
            roleList.add(role);
        });
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setRoleList(roleList);
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuarioDTO.getSenha()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

}

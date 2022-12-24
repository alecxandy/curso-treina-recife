package com.treina.treina.controller;

import com.treina.treina.service.UserDetailServiceImpl;
import com.treina.treina.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios/")
@RequiredArgsConstructor
public class UsuarioController {

    private final UserDetailServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Usuario> salvar(Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
    }

}

package com.treina.treina.service;

import com.treina.treina.model.Usuario;
import com.treina.treina.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service//classe de configuração do detalhes do usuario de implementação
@Transactional//Resolveu o carregamento das rules
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override//Encontrar usuario
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByNome(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));

        return new User(usuario.getNome(), usuario.getSenha()
                , true
                , true
                , true
                , true
                , usuario.getAuthorities());

    }
}

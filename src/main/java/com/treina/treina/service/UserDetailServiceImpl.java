package com.treina.treina.service;

import com.treina.treina.model.Usuario;
import com.treina.treina.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//Definir carregamento de usuarios atraves de uma base de dados
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    //salvar
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    //Carregar usuario por nome;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //se o usuario estar cadastrado
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User não encontrado"));

        String[] roles = usuario.isAdmin() ?
                new String[]{"ADMIN", "USER"} : new String[]{"USER"};
        //retornando um usuario
        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();

    }
}

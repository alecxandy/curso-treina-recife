package com.treina.treina.config;

import com.treina.treina.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    //metodo de criptografia
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override//Metodo de configuração de autenticação
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Carregar os usuarios do userDetailsService
        auth
                .userDetailsService(userDetailService)//forma de autenticação
                .passwordEncoder(passwordEncoder());//tipo de password

      /*
      auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("alex")//Usuario
                .password(passwordEncoder().encode("1234"))//Senha criptografada
                .roles("USER", "ADMIN");//Perfil de usuario
      */

    }


    @Override//Metodo de configuração de autorização
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/professores/**").hasRole("USER")
                .antMatchers("/api/alunos/**").hasAnyRole("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/api/usuarios/").permitAll()
                .and().httpBasic();//login padrao do security
    }


}

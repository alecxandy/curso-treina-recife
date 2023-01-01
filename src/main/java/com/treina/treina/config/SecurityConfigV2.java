package com.treina.treina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration//Nova classe de configuração do spring security
public class SecurityConfigV2 extends GlobalMethodSecurityConfiguration {

    //metodo de autorização
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                /* .antMatchers(HttpMethod.GET, "/api/role/**").hasRole("ADMIN")
                 .antMatchers(HttpMethod.POST, "/api/Usuario/**").hasRole("ADMIN")
                 .antMatchers(HttpMethod.GET, "/api/**").permitAll()*/
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return httpSecurity.build();
    }


    //Gerador de senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

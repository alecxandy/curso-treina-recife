package com.treina.treina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Curso;

public interface CursoRepository extends JpaRepository <Curso ,Long> {
    
}

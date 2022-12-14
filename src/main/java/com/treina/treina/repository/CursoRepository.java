package com.treina.treina.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Curso;

import java.util.List;

public interface CursoRepository extends JpaRepository <Curso ,Long> {
    @Override
    Page<Curso> findAll(Pageable pageable);
}

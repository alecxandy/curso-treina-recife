package com.treina.treina.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Override
    Page<Turma> findAll(Pageable pageable);
}

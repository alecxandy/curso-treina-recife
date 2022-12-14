package com.treina.treina.repository;

import com.treina.treina.model.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByNomeContains(String nome);

    @Override
    Page<Professor> findAll(Pageable pageable);
}

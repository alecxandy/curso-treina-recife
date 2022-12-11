package com.treina.treina.repository;

import com.treina.treina.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Professor;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findByNomeContains(String nome);
}

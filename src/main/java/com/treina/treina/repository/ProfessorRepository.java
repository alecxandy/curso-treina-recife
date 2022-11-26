package com.treina.treina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Professor;

public interface ProfessorRepository  extends JpaRepository<Professor,Long>{
    
}

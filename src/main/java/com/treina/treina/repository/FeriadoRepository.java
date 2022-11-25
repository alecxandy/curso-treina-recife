package com.treina.treina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Feriado;

public interface FeriadoRepository extends JpaRepository <Feriado,Long> {
    
}

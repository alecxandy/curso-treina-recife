package com.treina.treina.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.Feriado;

import java.util.List;

public interface FeriadoRepository extends JpaRepository <Feriado,Long> {

    @Override
    Page<Feriado> findAll(Pageable pageable);
}

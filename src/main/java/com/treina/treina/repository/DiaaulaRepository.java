package com.treina.treina.repository;

import com.treina.treina.model.DiaAula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiaaulaRepository extends JpaRepository<DiaAula, Long> {

    @Override
    Page<DiaAula> findAll(Pageable pageable);
}

package com.treina.treina.repository;

import com.treina.treina.model.Sala;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    @Override
    Page<Sala> findAll(Pageable pageable);
}

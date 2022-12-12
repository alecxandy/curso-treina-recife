package com.treina.treina.repository;

import com.treina.treina.model.Lead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead,Long> {

    @Override
    Page<Lead> findAll(Pageable pageable);
}

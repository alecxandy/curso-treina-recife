package com.treina.treina.repository;

import com.treina.treina.model.DiaAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaaulaRepository extends JpaRepository<DiaAula, Long> {

}

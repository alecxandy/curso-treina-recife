package com.treina.treina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.treina.model.DiaAula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaaulaRepository extends JpaRepository<DiaAula, Long> {

    @Query(nativeQuery = true, value = "delete from tb_dia_aula as d where turma_id_fk =:id;")
    void deletarTurma(@Param("id") Long id);
}

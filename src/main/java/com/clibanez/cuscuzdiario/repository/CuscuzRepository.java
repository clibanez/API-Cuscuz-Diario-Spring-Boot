package com.projeto.cuscuzdiario.repository;

import com.projeto.cuscuzdiario.domian.Cuscuz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuscuzRepository extends JpaRepository<Cuscuz, Integer>{
    
}

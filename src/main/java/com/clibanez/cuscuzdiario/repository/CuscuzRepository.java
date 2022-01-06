package com.clibanez.cuscuzdiario.repository;



import com.clibanez.cuscuzdiario.domian.Cuscuz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuscuzRepository extends JpaRepository<Cuscuz, Integer>{
    
}

package com.clibanez.cuscuzdiario.repository;



import com.clibanez.cuscuzdiario.domian.Biblia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliaRepository extends JpaRepository<Biblia, Integer>{
    
}

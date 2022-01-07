package com.clibanez.cuscuzdiario.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.clibanez.cuscuzdiario.domian.Biblia;
import com.clibanez.cuscuzdiario.domian.dtos.BibliaDTO;
import com.clibanez.cuscuzdiario.repository.BibliaRepository;
import com.clibanez.cuscuzdiario.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibliaService {

    @Autowired
    private BibliaRepository repo;

    public Biblia findById(Integer id) {
        Optional<Biblia> biblia = repo.findById(id);
        return biblia.orElseThrow(() -> new ObjectNotFoundException
        ("Objeto não encontrado Id " + id));
    }

    public List<Biblia> findAll(){
        return repo.findAll();
    }
   
    public Biblia create(BibliaDTO objDTO){
        objDTO.setId(null);
        Biblia newObj = new Biblia(objDTO);
        return repo.save(newObj);
    }

    public Biblia update(Integer id,@Valid BibliaDTO objDTO) { 
       objDTO.setId(id);
       Biblia oldObj = findById(id);
        oldObj = new Biblia(objDTO);
        return repo.save(oldObj);

    }

    public void delete(Integer id){
        Biblia obj = findById(id);
        repo.deleteById(id);
        

    }


    
}

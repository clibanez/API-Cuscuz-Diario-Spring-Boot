package com.clibanez.cuscuzdiario.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.clibanez.cuscuzdiario.domian.Cuscuz;
import com.clibanez.cuscuzdiario.domian.dtos.CuscuzDTO;
import com.clibanez.cuscuzdiario.repository.CuscuzRepository;
import com.clibanez.cuscuzdiario.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuscuzService {

    @Autowired
    private CuscuzRepository repo;

    public Cuscuz findById(Integer id) {
        Optional<Cuscuz> cuscuz = repo.findById(id);
        return cuscuz.orElseThrow(() -> new ObjectNotFoundException
        ("Objeto não encontrado Id " + id));
    }

    public List<Cuscuz> findAll(){
        return repo.findAll();
    }
   
    public Cuscuz create(CuscuzDTO objDTO){
        objDTO.setId(null);
        Cuscuz newObj = new Cuscuz(objDTO);
        return repo.save(newObj);
    }

    public Cuscuz update(Integer id,@Valid CuscuzDTO objDTO) { 
       objDTO.setId(id);
       Cuscuz oldObj = findById(id);
        oldObj = new Cuscuz(objDTO);
        return repo.save(oldObj);

    }

    public void delete(Integer id){
        Cuscuz obj = findById(id);
        repo.deleteById(id);
        
        

    }


    
}

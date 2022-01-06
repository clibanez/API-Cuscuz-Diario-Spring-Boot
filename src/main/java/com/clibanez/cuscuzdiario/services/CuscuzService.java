package com.clibanez.cuscuzdiario.services;

import java.util.List;
import java.util.Optional;

import com.clibanez.cuscuzdiario.domian.Cuscuz;
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
        ("Objeto não encontrado Id " + id + "Tipo " + Cuscuz.class.getName()));
    }

    public List<Cuscuz> findAll(){
        return repo.findAll();
    }

    public Cuscuz save(Cuscuz cuscuz){
        cuscuz.setId(null);
        return repo.save(cuscuz);

    }


    public Cuscuz update(Cuscuz cuscuz){
        Cuscuz newCuscuz = new Cuscuz();
        updateCuscuz(cuscuz, newCuscuz);
        return repo.save(cuscuz);
    }

    private void updateCuscuz(Cuscuz oldCuscuz, Cuscuz newCuscuz) {
        newCuscuz.setTitulo(oldCuscuz.getTitulo());
        newCuscuz.setTexto(oldCuscuz.getTexto());
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }


    
}

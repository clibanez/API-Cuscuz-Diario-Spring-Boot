package com.clibanez.cuscuzdiario.resources;


import java.util.List;

import com.clibanez.cuscuzdiario.domian.Cuscuz;
import com.clibanez.cuscuzdiario.services.CuscuzService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cuscuz")
@CrossOrigin("*")
public class CuscuzResource {

    @Autowired
    private CuscuzService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cuscuz> findById(@PathVariable Integer id){
        Cuscuz cuscuz = service.findById(id);
        return ResponseEntity.ok().body(cuscuz);
    }

    @GetMapping
    public ResponseEntity<List<Cuscuz>> findAll(){
        List<Cuscuz> cuscuz = service.findAll();
        return ResponseEntity.ok().body(cuscuz);
    }


    @PostMapping
    public ResponseEntity<Cuscuz> save(@RequestBody Cuscuz cuscuz) {
        Cuscuz obj = service.save(cuscuz);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping
    public ResponseEntity<Cuscuz> update(@RequestBody Cuscuz cuscuz){
        Cuscuz obj = service.update(cuscuz);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    
}

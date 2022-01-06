package com.clibanez.cuscuzdiario.resources;

import java.util.List;

import com.clibanez.cuscuzdiario.domian.Biblia;
import com.clibanez.cuscuzdiario.services.BibliaService;

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
@RequestMapping(value = "/biblias")
@CrossOrigin("*")
public class BibliaResource {

    @Autowired
    private BibliaService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Biblia> findById(@PathVariable Integer id){
        Biblia biblia = service.findById(id);
        return ResponseEntity.ok().body(biblia);
    }

    @GetMapping
    public ResponseEntity<List<Biblia>> findAll(){
        List<Biblia> biblia = service.findAll();
        return ResponseEntity.ok().body(biblia);
    }


    @PostMapping
    public ResponseEntity<Biblia> save(@RequestBody Biblia biblia) {
        Biblia obj = service.save(biblia);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping
    public ResponseEntity<Biblia> update(@RequestBody Biblia biblia){
        Biblia obj = service.update(biblia);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}

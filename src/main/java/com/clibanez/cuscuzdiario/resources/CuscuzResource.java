package com.clibanez.cuscuzdiario.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.clibanez.cuscuzdiario.domian.Cuscuz;
import com.clibanez.cuscuzdiario.domian.dtos.CuscuzDTO;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/cuscuz")
@CrossOrigin("*")
public class CuscuzResource {

    @Autowired
    private CuscuzService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<CuscuzDTO> findById(@PathVariable Integer id){
        Cuscuz obj = service.findById(id);
        return ResponseEntity.ok().body(new CuscuzDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<CuscuzDTO>> findAll(){
        List<Cuscuz> list = service.findAll();
        List<CuscuzDTO> listDTO = list.stream().map(obj -> new CuscuzDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<CuscuzDTO> create(@Valid @RequestBody CuscuzDTO objDTO){
        Cuscuz newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<CuscuzDTO> update(@PathVariable Integer id, @Valid @RequestBody CuscuzDTO objDTO){
        Cuscuz obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new CuscuzDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CuscuzDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }


    
}

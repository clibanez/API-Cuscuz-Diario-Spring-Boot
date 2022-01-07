package com.clibanez.cuscuzdiario.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.clibanez.cuscuzdiario.domian.Biblia;
import com.clibanez.cuscuzdiario.domian.dtos.BibliaDTO;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/biblias")
@CrossOrigin("*")
public class BibliaResource {

    @Autowired
    private BibliaService service;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<BibliaDTO> findById(@PathVariable Integer id){
        Biblia obj = service.findById(id);
        return ResponseEntity.ok().body(new BibliaDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<BibliaDTO>> findAll(){
        List<Biblia> list = service.findAll();
        List<BibliaDTO> listDTO = list.stream().map(obj -> new BibliaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<BibliaDTO> create(@Valid @RequestBody BibliaDTO objDTO){
        Biblia newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<BibliaDTO> update(@PathVariable Integer id, @Valid @RequestBody BibliaDTO objDTO){
        Biblia obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new BibliaDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BibliaDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    
}

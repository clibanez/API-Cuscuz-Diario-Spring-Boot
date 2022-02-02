package com.clibanez.cuscuzdiario.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.clibanez.cuscuzdiario.domian.Usuario;
import com.clibanez.cuscuzdiario.domian.dtos.UsuarioDTO;
import com.clibanez.cuscuzdiario.repository.UsuarioRepository;
import com.clibanez.cuscuzdiario.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException
        ("Objeto não encontrado Id " + id));
    }

    public List<Usuario> findAll(){
        return repo.findAll();
    }
   
    public Usuario create(UsuarioDTO objDTO){
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        validaPorEmail(objDTO);
        Usuario newObj = new Usuario(objDTO);
        return repo.save(newObj);
    }

    
    public Usuario update(Integer id,@Valid UsuarioDTO objDTO) { 
       objDTO.setId(id);
       validaPorEmail(objDTO);
       Usuario oldObj = findById(id);
        oldObj = new Usuario(objDTO);
        return repo.save(oldObj);

    }

    public void delete(Integer id){
        Usuario obj = findById(id);
        repo.deleteById(id);
        

    }

    private void validaPorEmail(UsuarioDTO objDTO) {
        Optional<Usuario> obj = repo.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()){
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
            
        }

    }


   
}

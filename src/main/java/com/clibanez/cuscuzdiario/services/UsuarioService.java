package com.clibanez.cuscuzdiario.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.clibanez.cuscuzdiario.domian.Usuario;
import com.clibanez.cuscuzdiario.domian.dtos.UsuarioDTO;
import com.clibanez.cuscuzdiario.repository.UsuarioRepository;
import com.clibanez.cuscuzdiario.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

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
        Usuario newObj = new Usuario(objDTO);
        return repo.save(newObj);
    }

    public Usuario update(Integer id,@Valid UsuarioDTO objDTO) { 
       objDTO.setId(id);
       Usuario oldObj = findById(id);
        oldObj = new Usuario(objDTO);
        return repo.save(oldObj);

    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }

    private void updateUsuario(Usuario oldUsuario, Usuario newUsuario) {
        newUsuario.setNome(oldUsuario.getNome());
        newUsuario.setSenha(oldUsuario.getSenha());
        newUsuario.setEmail(oldUsuario.getEmail());

    }

    public void delete(Integer id){
        repo.deleteById(id);
    }




   
   
}

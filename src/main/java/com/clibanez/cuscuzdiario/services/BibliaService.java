package com.clibanez.cuscuzdiario.services;

import java.util.List;
import java.util.Optional;

import com.clibanez.cuscuzdiario.domian.Biblia;
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
        ("Objeto não encontrado Id " + id + "Tipo " + Biblia.class.getName()));
    }

    public List<Biblia> findAll(){
        return repo.findAll();
    }

    public Biblia save(Biblia biblia){
        biblia.setId(null);
        return repo.save(biblia);

    }

    public Biblia update(Biblia biblia){
        Biblia newBiblia = new Biblia();
        updateBiblia(biblia, newBiblia);
        return repo.save(biblia);
    }

    private void updateBiblia(Biblia oldBiblia, Biblia newBiblia) {
        newBiblia.setLivro(oldBiblia.getLivro());
        newBiblia.setVersiculo(oldBiblia.getCapitulo());
        newBiblia.setVersiculo(oldBiblia.getVersiculo());
        newBiblia.setVersao(oldBiblia.getVersao());
        
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }


    
}

package com.projeto.cuscuzdiario.Services;

import java.util.Arrays;

import com.projeto.cuscuzdiario.domian.Biblia;
import com.projeto.cuscuzdiario.domian.Cuscuz;
import com.projeto.cuscuzdiario.domian.Usuario;
import com.projeto.cuscuzdiario.repository.BibliaRepository;
import com.projeto.cuscuzdiario.repository.CuscuzRepository;
import com.projeto.cuscuzdiario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CuscuzRepository cuscuzRepository;

    @Autowired
    private BibliaRepository bibliaRepository;



    public void instanciaDB() {

        Usuario usu1 = new Usuario(null, "Clibanez", "!DDFF", "Cliabenz@gmail.com");
        Usuario usu2 = new Usuario(null, "Matheus", "!D344FF", "Matheus@gmail.com");

        Cuscuz cus1 = new Cuscuz(null, "Gênesis", "A palavra", usu1);
        Cuscuz cus2 = new Cuscuz(null, "João", "Discipulo", usu2);

        Biblia bib1 = new Biblia(null, "Salmo", "cap 1", "ver 3", "Genebra");
        Biblia bib2 = new Biblia(null, "Daniel", "cap 18", "ver 33", "Plenitude");

        cus1.getBlibias().addAll(Arrays.asList(bib1,bib2));
        

        bib1.getCuscuzz().addAll(Arrays.asList(cus2));



        

        

        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

        cuscuzRepository.saveAll(Arrays.asList(cus1, cus2));

        bibliaRepository.saveAll(Arrays.asList(bib1, bib2));

    }

    
}

package com.clibanez.cuscuzdiario.services;

import java.util.Arrays;

import com.clibanez.cuscuzdiario.domian.Biblia;
import com.clibanez.cuscuzdiario.domian.Cuscuz;
import com.clibanez.cuscuzdiario.domian.Usuario;
import com.clibanez.cuscuzdiario.repository.BibliaRepository;
import com.clibanez.cuscuzdiario.repository.CuscuzRepository;
import com.clibanez.cuscuzdiario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CuscuzRepository cuscuzRepository;

    @Autowired
    private BibliaRepository bibliaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;




    public void instanciaDB() {

        Usuario usu1 = new Usuario(null, "Clibanez", encoder.encode("123"), "test@gmail.com");
        Usuario usu2 = new Usuario(null, "Matheus", encoder.encode("123"), "test1@gmail.com");

        Cuscuz cus1 = new Cuscuz(null, "Pr. Davi Cuscuz Diário Bom dia!!", "Como o Cordeiro de {Somos todos teólogos}", usu1);
        Cuscuz cus2 = new Cuscuz(null, "Pr. Davi Cuscuz Diário Bom dia!!!", "Assim feria o teu se", usu2);
        Cuscuz cus3 = new Cuscuz(null, "Pr. Davi Cuscuz Diário Bom dia!", "ARREPENDEI-VOZ...! O povo", usu1);

        Biblia bib1 = new Biblia(null, "Provérbios", "cap 30", "ver 17", "“Os olhos de quem zomba do pai ou de quem despreza a obediência à sua mãe,corvos no ribeiro os arranca.”");
        Biblia bib2 = new Biblia(null, "Provérbios", "cap 6", "ver 6", "“Vai ter com a formiga, ó preguiçoso; olha para os seus caminhos e sê sábio.”");

        cus1.getBlibias().addAll(Arrays.asList(bib1,bib2));
        usu1.getCuscuz().addAll(Arrays.asList(cus1,cus2, cus3));
        
        

       bib1.getCuscuzz().addAll(Arrays.asList(cus2));



        

        

        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

        cuscuzRepository.saveAll(Arrays.asList(cus1, cus2));

        bibliaRepository.saveAll(Arrays.asList(bib1, bib2));

    }

    
}

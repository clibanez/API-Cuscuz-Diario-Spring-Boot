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

        Cuscuz cus1 = new Cuscuz(null, "Pr. Davi Cuscuz Diário Bom dia!", "Como o Cordeiro de Deus, Cristo foi à cruz e sofreu a ira de Deus, mas não por qualquer pecado que Deus achou nele. Cristo tomou voluntariamente sobre si mesmo os nossos pecados. Ele se tornou o carregador de pecados quando Deus, o Pai, transferiu ou atribuiu nossos pecados a ele. No momento em que colocamos nossa confiança em Jesus Cristo, tudo que ele é e tudo que ele possui se tornam nosso; e somos transportados imediatamente para um estado de reconciliação com Deus. Sproul {Somos todos teólogos}", usu1);
        Cuscuz cus2 = new Cuscuz(null, "Pr. Davi Cuscuz Diário Bom dia!", "Assim feria o teu servo o leão, como o urso; assim será este incircunciso filisteu como um deles; porquanto afrontou os exércitos do Deus vivo. I Samuel 17.36 Por mais que Davi tenha vencido um leão e um urso e contara isso ao rei Saul como uma prova de que poderia também vencer Golias, ele sabia que nele mesmo não havia poder algum. Davi não estava confiando nele, Davi estava lembrando de experiências com o seu Deus. Davi olhou para trás e viu os grandes feitos de Deus em sua vida e acreditou que assim como foi no passado seria também no presente (O Senhor me livrou das garras do leão, e das do urso; ele me livrará da mão deste filisteu. Então disse Saul a Davi: Vai, e o Senhor seja contigo.). Todos nós dia a dia enfrentamos um Golias. Por vezes sentimo-nos fracos e amedrontados com o tamanho do gigante. Nestas horas, o que fazer?, OLHE PARA O RETROVISOR, veja o que fez o Senhor por sua vida, vislumbre os seus livramentos e quão incontáveis foram as  vitórias alcançadas em nome do Deus vivo. Acredite, o Senhor é contigo. Rev. Davi Dionisio", usu2);
        Cuscuz cus3 = new Cuscuz(null, "Pr. Davi Cuscuz Diário Bom dia!", "ARREPENDEI-VOZ! O povo de Deus precisa passar pela porta do arrependimento para ser perdoado e curado. Nosso país está doente e caído pelos seus pecados. Desde o palácio às choupanas, desde o parlamento às cortes, desde a igreja às famílias, desde à indústria ao comércio, desde as salas das escolas às ruas, nossa nação tem multiplicado seus pecados contra Deus. O descalabro moral que feriu com golpes profundos nossa classe política e importantes setores da sociedade é consequência desse descaso com as coisas de Deus. A solução para o Brasil está em Deus. Se nos voltarmos para Deus em arrependimento, ele se voltará para nós em graça e misericórdia! Rev. Hernandes Dias Lopes", usu1);

        Biblia bib1 = new Biblia(null, "Provérbios", "cap 30", "ver 17", "“Os olhos de quem zomba do pai ou de quem despreza a obediência à sua mãe,corvos no ribeiro os arrancarão e pelos pintãos da águia serão comidos.”");
        Biblia bib2 = new Biblia(null, "Provérbios", "cap 6", "ver 6", "“Vai ter com a formiga, ó preguiçoso; olha para os seus caminhos e sê sábio.”");

        cus1.getBlibias().addAll(Arrays.asList(bib1,bib2));
        usu1.getCuscuz().addAll(Arrays.asList(cus1,cus2, cus3));
        
        

       bib1.getCuscuzz().addAll(Arrays.asList(cus2));



        

        

        usuarioRepository.saveAll(Arrays.asList(usu1, usu2));

        cuscuzRepository.saveAll(Arrays.asList(cus1, cus2));

        bibliaRepository.saveAll(Arrays.asList(bib1, bib2));

    }

    
}

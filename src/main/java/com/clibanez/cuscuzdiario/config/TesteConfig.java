package com.clibanez.cuscuzdiario.config;



import com.clibanez.cuscuzdiario.services.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("teste")
public class TesteConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instanciaDB(){
        this.dbService.instanciaDB();
    }
    
}

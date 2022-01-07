package com.clibanez.cuscuzdiario.domian.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.clibanez.cuscuzdiario.domian.Cuscuz;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CuscuzDTO {
   
    
   private Integer id;

    
    @NotNull(message = "O campo NOME é requerido")
    private String titulo;

    @NotNull(message = "O campo NOME é requerido")
    private String texto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    CuscuzDTO(){
        super();
    }

    public CuscuzDTO(Cuscuz obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.texto = obj.getTexto();
        this.dataCriacao = obj.getDataCriacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    

    

    
}

package com.clibanez.cuscuzdiario.domian.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.clibanez.cuscuzdiario.domian.Cuscuz;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter@Getter
public class CuscuzDTO {
   
    
   private Integer id;

    
    @NotNull(message = "O campo NOME é requerido")
    private String titulo;

    @NotNull(message = "O campo NOME é requerido")
    private String texto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    public CuscuzDTO(Cuscuz obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.texto = obj.getTexto();
        this.dataCriacao = obj.getDataCriacao();
    }
    
}

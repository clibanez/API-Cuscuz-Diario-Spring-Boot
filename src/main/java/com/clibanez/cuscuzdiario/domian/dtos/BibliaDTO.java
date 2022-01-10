package com.clibanez.cuscuzdiario.domian.dtos;

import javax.validation.constraints.NotNull;

import com.clibanez.cuscuzdiario.domian.Biblia;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter@Getter
public class BibliaDTO {

   
    private Integer id;

    @NotNull(message = "O campo LIVRO é requerido")
    private String livro;
    @NotNull(message = "O campo CAPITULO é requerido")
    private String capitulo;
    @NotNull(message = "O campo VERSICULO é requerido")
    private String versiculo;
    @NotNull(message = "O campo VERSAO é requerido")
    private String versao;

    public BibliaDTO(Biblia obj){
        super();
        this.id = obj.getId();
        this.livro = obj.getLivro();
        this.capitulo = obj.getCapitulo();
        this.versiculo = obj.getVersiculo();
        this.versao = obj.getVersao();
    }

}

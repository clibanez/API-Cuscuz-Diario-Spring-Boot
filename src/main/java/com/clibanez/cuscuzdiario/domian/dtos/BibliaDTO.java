package com.clibanez.cuscuzdiario.domian.dtos;

import javax.validation.constraints.NotNull;

import com.clibanez.cuscuzdiario.domian.Biblia;

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

    public BibliaDTO(){
        super();
    }

    public BibliaDTO(Biblia obj){
        super();
        this.id = obj.getId();
        this.livro = obj.getLivro();
        this.capitulo = obj.getCapitulo();
        this.versiculo = obj.getVersiculo();
        this.versao = obj.getVersao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getVersiculo() {
        return versiculo;
    }

    public void setVersiculo(String versiculo) {
        this.versiculo = versiculo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    
    
}

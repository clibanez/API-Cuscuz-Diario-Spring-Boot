package com.clibanez.cuscuzdiario.domian;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.clibanez.cuscuzdiario.domian.dtos.BibliaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Setter@Getter
@Entity
public class Biblia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String livro;
    private String capitulo;
    private String versiculo;
    private String versao;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "BIBLIA_CUSCUZ",
    joinColumns = @JoinColumn(name = "biblia_id"),
    inverseJoinColumns = @JoinColumn (name = "cuscuz_id" ))
    private List<Cuscuz> cuscuzz = new ArrayList<>();

    public Biblia(Integer id, String livro, String capitulo, String versiculo, String versao) {
        this.id = id;
        this.livro = livro;
        this.capitulo = capitulo;
        this.versiculo = versiculo;
        this.versao = versao;
    }

    public Biblia(BibliaDTO obj){
        this.id = obj.getId();
        this.livro = obj.getLivro();
        this.capitulo = obj.getCapitulo();
        this.versiculo = obj.getVersiculo();
        this.versao = obj.getVersao();
    }

}

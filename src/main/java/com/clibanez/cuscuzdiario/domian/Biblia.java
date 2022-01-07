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

    public Biblia(){
    super();
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Biblia other = (Biblia) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
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

    public List<Cuscuz> getCuscuzz() {
        return cuscuzz;
    }

    public void setCuscuzz(List<Cuscuz> cuscuzz) {
        this.cuscuzz = cuscuzz;
    }


    



    

    




 
    

    
}

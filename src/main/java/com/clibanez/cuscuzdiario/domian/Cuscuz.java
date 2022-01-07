package com.clibanez.cuscuzdiario.domian;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.clibanez.cuscuzdiario.domian.dtos.CuscuzDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cuscuz {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    
    @Column(unique = true)
    private String titulo;

    private String texto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();
    
    @JsonIgnore
    @ManyToMany(mappedBy = "cuscuzz")
    private List<Biblia> blibias = new ArrayList<>();

   
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



 public Cuscuz(){
     super();

 }

 


public Cuscuz(Integer id, String titulo, String texto, Usuario usuario) {
    this.id = id;
    this.titulo = titulo;
    this.texto = texto;
    this.usuario = usuario;
}

public Cuscuz(CuscuzDTO obj){
    super();
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


public List<Biblia> getBlibias() {
    return blibias;
}




public void setBlibias(List<Biblia> blibias) {
    this.blibias = blibias;
}




@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
}




@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Cuscuz other = (Cuscuz) obj;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}






 



 
}

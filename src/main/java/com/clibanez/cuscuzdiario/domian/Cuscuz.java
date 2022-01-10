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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Setter@Getter
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

}

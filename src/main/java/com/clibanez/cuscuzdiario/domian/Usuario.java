package com.clibanez.cuscuzdiario.domian;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.clibanez.cuscuzdiario.domian.dtos.UsuarioDTO;

import org.hibernate.validator.constraints.Length;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Setter@Getter
@Entity
public class Usuario {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nome;

    private String senha;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "usuario")
    private List<Cuscuz> cuscuz = new ArrayList<>();

    
    public Usuario(UsuarioDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.senha = obj.getSenha();
        this.email = obj.getEmail();
    }

    public Usuario(Integer id,
            @NotEmpty(message = "Preenchimento campo nome obrigatorio") @Length(min = 6, max = 20, message = "O tamanho deve ser entre 6 e 20 caracteres") String nome,
            @NotEmpty(message = "Preenchimento da senha obrigatoria") @Length(min = 4, max = 8, message = "O tamanho deve ser entre 5 e 8 caracteres") String senha,
            @NotEmpty(message = "Preenchimento do campo email obrigatorio") String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

}

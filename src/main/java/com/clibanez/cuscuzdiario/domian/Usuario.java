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


    public Usuario(){

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


    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getSenha() {
        return senha;
    }



    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
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
        Usuario other = (Usuario) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    

    



    
    
    

}

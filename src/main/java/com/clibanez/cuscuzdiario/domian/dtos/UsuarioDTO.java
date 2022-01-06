package com.clibanez.cuscuzdiario.domian.dtos;

import javax.validation.constraints.NotNull;

import com.clibanez.cuscuzdiario.domian.Usuario;

public class UsuarioDTO {

   
    private Integer id;
    
    @NotNull(message = "O campo NOME é requerido")
    private String nome;
    @NotNull(message = "O campo SENHA é requerido")
    private String senha;
    @NotNull(message = "O campo EMAIL é requerido")
    private String email;

    public UsuarioDTO(){
        super();
    }

    public UsuarioDTO(Usuario obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.senha = obj.getSenha();
        this.email = obj.getEmail();
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
    
}

package com.clibanez.cuscuzdiario.domian.dtos;

import com.clibanez.cuscuzdiario.domian.Usuario;

public class UsuarioDTO {

   
    private Integer id;
    private String nome;
    private String senha;
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

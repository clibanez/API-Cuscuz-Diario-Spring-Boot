package com.clibanez.cuscuzdiario.domian.dtos;

import javax.validation.constraints.NotNull;

import com.clibanez.cuscuzdiario.domian.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter@Getter
public class UsuarioDTO {

   
    private Integer id;
    
    @NotNull(message = "O campo NOME é requerido")
    private String nome;
    @NotNull(message = "O campo SENHA é requerido")
    private String senha;
    @NotNull(message = "O campo EMAIL é requerido")
    private String email;

    public UsuarioDTO(Usuario obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.senha = obj.getSenha();
        this.email = obj.getEmail();
    }

}

package com.clibanez.cuscuzdiario.services;

import java.util.Optional;

import com.clibanez.cuscuzdiario.domian.Usuario;
import com.clibanez.cuscuzdiario.repository.UsuarioRepository;
import com.clibanez.cuscuzdiario.security.UserSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{


    @Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Optional<Usuario> user =repo.findByEmail(email);
       if(user.isPresent()) {
           return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getSenha());
       }
       throw new UsernameNotFoundException(email);


    }
    
}

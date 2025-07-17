package com.ufrn.lojagamesretro.service;

import com.ufrn.lojagamesretro.domain.DomainCliente; // Importar DomainCliente
import org.springframework.security.core.userdetails.User; // Importar User do Spring Security
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ufrn.lojagamesretro.repository.SecurityUserRepository;

@Service
public class SecurityUserService implements UserDetailsService {
    private final SecurityUserRepository repository;

    public SecurityUserService(SecurityUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuário: " + username);
        DomainCliente cliente = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        // Retorna um UserDetails do Spring Security
        return User.builder()
                .username(cliente.getUsername())
                .password(cliente.getPassword())
                .roles(cliente.getRoles().split(",")) // Assumindo que roles é uma string separada por vírgulas, ex: "ADMIN,USER"
                .build();
    }
}
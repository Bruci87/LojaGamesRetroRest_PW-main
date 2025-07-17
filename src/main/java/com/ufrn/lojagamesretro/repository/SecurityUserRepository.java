package com.ufrn.lojagamesretro.repository;

import com.ufrn.lojagamesretro.domain.DomainCliente; // Alterado para DomainCliente
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<DomainCliente, Long> { // Alterado o tipo do ID para Long
    Optional<DomainCliente> findByUsername(String username);
}
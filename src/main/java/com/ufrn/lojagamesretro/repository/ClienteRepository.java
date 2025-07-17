package com.ufrn.lojagamesretro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufrn.lojagamesretro.domain.DomainCliente;
public interface ClienteRepository extends JpaRepository<DomainCliente, Long>{

}

package com.ufrn.lojagamesretro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ufrn.lojagamesretro.domain.DomainCarrinho;
public interface CarrinhoRepository extends JpaRepository<DomainCarrinho, Long> {
}

package com.ufrn.lojagamesretro.service;

import org.springframework.stereotype.Service;
import com.ufrn.lojagamesretro.domain.DomainCarrinho;
import com.ufrn.lojagamesretro.repository.CarrinhoRepository;
@Service
public class CarrinhoService extends AbstractService<DomainCarrinho, CarrinhoRepository> {
    public CarrinhoService(CarrinhoRepository repo) {
        super(repo);
    }
}

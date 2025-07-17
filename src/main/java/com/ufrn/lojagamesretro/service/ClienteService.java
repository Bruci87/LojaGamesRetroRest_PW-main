package com.ufrn.lojagamesretro.service;

import org.springframework.stereotype.Service;
import com.ufrn.lojagamesretro.domain.DomainCliente;
import com.ufrn.lojagamesretro.repository.ClienteRepository;
@Service
public class ClienteService extends AbstractService<DomainCliente, ClienteRepository> {
    public ClienteService(ClienteRepository repository) {
        super(repository);
    }
}

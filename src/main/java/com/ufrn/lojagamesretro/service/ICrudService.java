package com.ufrn.lojagamesretro.service;

import com.ufrn.lojagamesretro.domain.DomainCliente;
import java.util.List;
import java.util.Optional;
public interface ICrudService<T> {
    public List<T> listar();
    public Optional<T> buscarPorId(Long id);
    public T adicionar(T c);
    public T alterar(T c);
    public void remover(Long id);
}

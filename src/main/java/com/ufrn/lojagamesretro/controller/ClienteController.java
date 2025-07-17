package com.ufrn.lojagamesretro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ufrn.lojagamesretro.core.exception.CategoriaNotFoundException; // Note que esta exceção pode não ser a mais apropriada para "Cliente"
import com.ufrn.lojagamesretro.domain.DomainCliente;
import com.ufrn.lojagamesretro.dto.ClienteResponseDTO;
import com.ufrn.lojagamesretro.dto.ClienteRequestDTO;
import com.ufrn.lojagamesretro.mapper.ClienteMapper;
import com.ufrn.lojagamesretro.service.ClienteService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes") // Alterado para /clientes para corresponder ao controlador
public class ClienteController {
    final ClienteService service;
    final ClienteMapper mapper;

    public ClienteController(ClienteService service, ClienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @GetMapping
    public List<ClienteResponseDTO> listar() {
        List<DomainCliente> clientes = service.listar();
        List<ClienteResponseDTO> dtos = new ArrayList<>();
        for (DomainCliente cliente : clientes) {
            ClienteResponseDTO localDto = mapper.doDtoCliente(cliente);
            dtos.add(localDto);
        }
        return dtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getClienteById(@PathVariable long id){
        Optional<DomainCliente> clienteOptional = service.buscarPorId(id);
        if(clienteOptional.isPresent()){
            ClienteResponseDTO dto = mapper.doDtoCliente(clienteOptional.get());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody ClienteRequestDTO requestDto) throws URISyntaxException {
        DomainCliente clienteEntity = mapper.toEntityCliente(requestDto);
        DomainCliente novoCliente = service.adicionar(clienteEntity);
        return ResponseEntity.created(new URI("/clientes/" + novoCliente.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable long id) throws CategoriaNotFoundException {
        Optional<DomainCliente> cliente = service.buscarPorId(id);
        if(cliente.isEmpty()){
            // Seria ideal ter uma ClienteNotFoundException aqui
            throw new CategoriaNotFoundException("Cliente com id " + id + " não encontrado.");
        }
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCliente(@RequestBody DomainCliente cliente, @PathVariable long id){
        Optional<DomainCliente> clienteExistente = service.buscarPorId(id);
        if(clienteExistente.isPresent()){
            return ResponseEntity.ok(service.alterar(cliente));
        }
        return ResponseEntity.notFound().build();
    }
}
package com.ufrn.lojagamesretro.mapper;

import org.mapstruct.Mapper;
import com.ufrn.lojagamesretro.domain.DomainCliente;
import com.ufrn.lojagamesretro.dto.ClienteRequestDTO;
import com.ufrn.lojagamesretro.dto.ClienteResponseDTO;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    DomainCliente toEntityCliente(ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO doDtoCliente(DomainCliente cliente);
}
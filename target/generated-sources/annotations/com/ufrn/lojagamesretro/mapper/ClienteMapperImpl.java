package com.ufrn.lojagamesretro.mapper;

import com.ufrn.lojagamesretro.domain.DomainCliente;
import com.ufrn.lojagamesretro.dto.ClienteRequestDTO;
import com.ufrn.lojagamesretro.dto.ClienteResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-17T13:46:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public DomainCliente toEntityCliente(ClienteRequestDTO clienteRequestDTO) {
        if ( clienteRequestDTO == null ) {
            return null;
        }

        DomainCliente domainCliente = new DomainCliente();

        domainCliente.setUsername( clienteRequestDTO.getUsername() );
        domainCliente.setPassword( clienteRequestDTO.getPassword() );

        return domainCliente;
    }

    @Override
    public ClienteResponseDTO doDtoCliente(DomainCliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

        clienteResponseDTO.setUsername( cliente.getUsername() );
        clienteResponseDTO.setPassword( cliente.getPassword() );

        return clienteResponseDTO;
    }
}

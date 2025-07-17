package com.ufrn.lojagamesretro.dto;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import com.ufrn.lojagamesretro.controller.ClienteController;
import com.ufrn.lojagamesretro.domain.DomainCarrinho;
import com.ufrn.lojagamesretro.domain.DomainCliente;

@Data
public class ClienteResponseDTO extends RepresentationModel<ClienteResponseDTO> {
    private String username;
    private String password;

    public void loadLinks(DomainCliente cliente) {
        this.add(WebMvcLinkBuilder.linkTo(ClienteController.class).slash(cliente.getId()).withSelfRel());
        this.add(WebMvcLinkBuilder.linkTo(ClienteController.class).withRel("pessoas"));
        this.add(WebMvcLinkBuilder.linkTo(ClienteController.class).slash(cliente.getId()).withRel("delete"));
    }

}

package com.ufrn.lojagamesretro.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class DomainCarrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private int estoque;
    private Date isDeleted;
    private String imgUrl;

}

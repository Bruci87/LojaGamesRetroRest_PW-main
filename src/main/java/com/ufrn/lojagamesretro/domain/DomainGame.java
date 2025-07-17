package com.ufrn.lojagamesretro.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "Jogo")
@Data
public class DomainGame {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        private long id;

        @Column(nullable = false)
        private String nomeJogo;

        private String genero;

        private int classificacao;
        @Column(nullable = false)
        private BigDecimal preco;

        private int estoque;

        private String tipoMidia;

        // CAMPOS ADICIONADOS CONFORME A ESPECIFICAÇÃO
        private String imgUrl;
        private Date isDeleted;
}

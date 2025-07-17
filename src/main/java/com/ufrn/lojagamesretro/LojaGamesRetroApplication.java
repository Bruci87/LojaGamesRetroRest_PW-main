package com.ufrn.lojagamesretro;

import com.ufrn.lojagamesretro.core.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class LojaGamesRetroApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaGamesRetroApplication.class, args);
    }
}
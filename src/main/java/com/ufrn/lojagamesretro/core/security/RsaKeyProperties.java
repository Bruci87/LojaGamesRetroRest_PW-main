package com.ufrn.lojagamesretro.core.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {

    // Estes campos serão preenchidos pelo Spring com os CAMINHOS dos arquivos (public-key -> publicKey)
    private String publicKey; // Renomeado de publicKeyLocation
    private String privateKey; // Renomeado de privateKeyLocation

    @Autowired
    private ResourceLoader resourceLoader;

    // Getters e Setters corrigidos para os novos nomes de campo
    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    // Métodos que carregarão e converterão as chaves do arquivo (usam os campos renomeados)
    public RSAPublicKey publicKey() {
        try {
            Resource resource = resourceLoader.getResource(publicKey); // Usa o campo 'publicKey'
            String keyContent = new String(resource.getInputStream().readAllBytes());
            byte[] keyBytes = Base64.getDecoder().decode(keyContent
                    .replaceAll("-----BEGIN PUBLIC KEY-----", "")
                    .replaceAll("-----END PUBLIC KEY-----", "")
                    .replaceAll("\\s", "")
            );
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPublicKey) kf.generatePublic(spec);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.err.println("Erro ao carregar a chave pública RSA do arquivo '" + publicKey + "': " + e.getMessage());
            throw new IllegalStateException("Falha ao carregar a chave pública RSA. Verifique o arquivo e a configuração.", e);
        }
    }

    public RSAPrivateKey privateKey() {
        try {
            Resource resource = resourceLoader.getResource(privateKey); // Usa o campo 'privateKey'
            String keyContent = new String(resource.getInputStream().readAllBytes());
            byte[] keyBytes = Base64.getDecoder().decode(keyContent
                    .replaceAll("-----BEGIN PRIVATE KEY-----", "")
                    .replaceAll("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s", "")
            );
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return (RSAPrivateKey) kf.generatePrivate(spec);
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.err.println("Erro ao carregar a chave privada RSA do arquivo '" + privateKey + "': " + e.getMessage());
            throw new IllegalStateException("Falha ao carregar a chave privada RSA. Verifique o arquivo e a configuração.", e);
        }
    }
}
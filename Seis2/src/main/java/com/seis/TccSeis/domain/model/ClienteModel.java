/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seis.TccSeis.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author kauar
 */
@Data
public class ClienteModel {
    
    
    @NotBlank
    @Size(max = 300)
    private String nome;
    
    @NotBlank
    @Size(max = 300)
    private String email;
    
    @NotBlank
    @Size(max = 20)
    private String telefone;
    
    @NotBlank
    @Size(max = 15)
    private String cpf;
    
    @NotBlank
    @Size(max = 300)
    private String cidade;
    
    @NotBlank
    @Size(max = 3)
    private String uf;
    
    @NotBlank
    @Size(max = 10)
    private String cep;
    
//    Inicio implementação Volume
    @NotBlank
    @Size(max = 300)
    private String peso;

    @NotBlank
    @Size(max = 300)
    private String altura;

    @NotBlank
    @Size(max = 300)
    private String largura;

    @NotBlank
    @Size(max = 300)
    private String profundidade;

    @NotBlank
    @Size(max = 300)
    private String destino;

    @NotBlank
    @Size(max = 300)
    private String origem;

    @NotBlank
    @Size(max = 150)
    private String status;

    @NotBlank
    @Size(max = 300)
    private String remetente;

    @NotBlank
    @Size(max = 300)
    private String destinatario;

    @NotBlank
    @Size(max = 300)
    private String transportador;

    @NotBlank
    @Size(max = 300)
    private String baseOrigem;

    @NotBlank
    @Size(max = 300)
    private String baseColeta;
    

    public ClienteModel() {
        //Defalt
    }

    public ClienteModel( String nome, String email, String telefone, String cpf, String cidade, String uf, String cep, String peso, String altura, String largura, String profundidade, String destino, String origem, String status, String remetente, String destinatario, String transportador, String baseOrigem, String baseColeta) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        
        //Implementação Volume
        
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.destino = destino;
        this.origem = origem;
        this.status = status;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.transportador = transportador;
        this.baseOrigem = baseOrigem;
        this.baseColeta = baseColeta;
    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    //Implentação Volume
    
    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }
    
    public String getLargura() {
        return largura;
    }

    public void setLargura(String largura) {
        this.largura = largura;
    }
    
    public String getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(String profundidade) {
        this.profundidade = profundidade;
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }
    
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
    public String getTransportador() {
        return transportador;
    }

    public void setTransportador(String transportador) {
        this.transportador = transportador;
    }
    
    public String getBaseOrigem() {
        return baseOrigem;
    }

    public void setBaseOrigem(String baseOrigem) {
        this.baseOrigem = baseOrigem;
    }
    
    public String getBaseColeta() {
        return baseColeta;
    }

    public void setBaseColeta(String baseColeta) {
        this.baseColeta = baseColeta;
    }
    


}

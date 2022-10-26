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
    private String id_Cliente;
    
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
    
    @NotBlank
    @Size(max = 150)
    private Boolean tipo;

    public ClienteModel() {
        //Defalt
    }

    public ClienteModel(String idCliente, String nome, String email, String telefone, String cpf, String cidade, String uf, String cep, Boolean tipo) {
        this.id_Cliente = id_Cliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.tipo = tipo;
    }
    
    
    
    public String getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(String id_Cliente) {
        this.id_Cliente = id_Cliente;
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
    
    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

}

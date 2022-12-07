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
public class DestinatarioModel {
    
    private String id_Destinatario;
    
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
    private String latitude;
    
    @NotBlank
    @Size(max = 11)
    private String longitude;
    

    public DestinatarioModel(String id_Destinatario, String nome, String email, String telefone, String cpf, String cidade, String uf, String latitude, String longitude) {
        this.id_Destinatario = id_Destinatario;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DestinatarioModel() {
    }
    
    public String getId_Destinatario() {
        return id_Destinatario;
    }

    public void setId_Destinatario(String id_Destinatario) {
        this.id_Destinatario = id_Destinatario;
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
    
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

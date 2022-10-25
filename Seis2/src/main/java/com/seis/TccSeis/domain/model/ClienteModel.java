/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seis.TccSeis.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author kauar
 */
@Data
@Entity
public class ClienteModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_cliente;
    private String email;
    private String telefone;
    private String cpf;
    private String cidade;
    private String uf;
    private String cep;
    private Boolean tipo;

    public ClienteModel(String id_cliente, String email, String telefone, String cpf, String cidade, String uf, String cep, Boolean tipo) {
        this.id_cliente = id_cliente;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.tipo = tipo;
    }
    
}

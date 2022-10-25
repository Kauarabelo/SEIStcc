/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.seis.TccSeis.domain.model;

import lombok.Data;

/**
 *
 * @author kauar
 */
@Data
public class ColaboradorModel {
    
    private String id_colaborador;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private String cidade;
    private String uf;
    private String latitude;
    private String longitude;
    private Boolean tipo;
    
}

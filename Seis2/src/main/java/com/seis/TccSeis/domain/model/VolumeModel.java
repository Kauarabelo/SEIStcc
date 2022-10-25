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
public class VolumeModel {
    
    private String id_volume;
    private String peso;
    private String altura;
    private String largura;
    private String profundidade;
    private String destino;
    private String origem;
    private String status;
    private String remetente;
    private String destinatario;
    private String transportador;
    private String baseOrigem;
    private String baseColeta;
    
}

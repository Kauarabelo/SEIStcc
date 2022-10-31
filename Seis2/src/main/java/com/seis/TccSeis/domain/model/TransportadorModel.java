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
public class TransportadorModel {
    
    private String id_Transportador;
    
    @NotBlank
    @Size(max = 15)
    private String cnh;
    
    @NotBlank
    @Size(max = 10)
    private String placaVeiculo;
    
    @NotBlank
    @Size(max = 150)
    private String modeloVeiculo;
    
    @NotBlank
    @Size(max = 15)
    private String documentoVeiculo;
    
    @NotBlank
    @Size(max = 5)
    private String anoVeiculo;
    
    @NotBlank
    @Size(max = 300)
    private String chavePix;

    public TransportadorModel() {
    }

    public TransportadorModel(String cnh, String placaVeiculo, String modeloVeiculo, String documentoVeiculo, String anoVeiculo, String chavePix) {
        this.cnh = cnh;
        this.placaVeiculo = placaVeiculo;
        this.modeloVeiculo = modeloVeiculo;
        this.documentoVeiculo = documentoVeiculo;
        this.anoVeiculo = anoVeiculo;
        this.chavePix = chavePix;
        this.id_Transportador = id_Transportador;
    }

    
    public String getId_Tranportador() {
        return id_Transportador;
    }

    public void setId_Transportador(String id_Transportador) {
        this.id_Transportador = id_Transportador;
    }
    
    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }
    
    public String getDocumentoVeiculo() {
        return documentoVeiculo;
    }

    public void setDocumentoVeiculo(String documentoVeiculo) {
        this.documentoVeiculo = documentoVeiculo;
    }
    
    public String getAnoVeiculo() {
        return anoVeiculo;
    }

    public void setAnoVeiculo(String anoVeiculo) {
        this.anoVeiculo = anoVeiculo;
    }
    
    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
    
}

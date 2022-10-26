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
public class VolumeModel {

    @NotBlank
    @Size(max = 300)
    private String id_volume;

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

    public VolumeModel() {
    }

    public VolumeModel(String id_volume, String peso, String altura, String largura, String profundidade, String destino, String origem, String status, String remetente, String destinatario, String transportador, String baseOrigem, String baseColeta) {
        this.id_volume = id_volume;
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

    public String getId_Volume() {
        return id_volume;
    }

    public void setId_Volume(String id_volume) {
        this.id_volume = id_volume;
    }
    
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

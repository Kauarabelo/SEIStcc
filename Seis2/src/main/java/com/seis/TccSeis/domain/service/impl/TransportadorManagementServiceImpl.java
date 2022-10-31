/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.domain.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seis.TccSeis.api.firebase.FirebaseInitializer;
import com.seis.TccSeis.domain.model.TransportadorModel;
import com.seis.TccSeis.domain.service.TransportadorService;

        

/**
 *
 * @author devsys-a
 */
@Service
public class TransportadorManagementServiceImpl implements TransportadorService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<TransportadorModel> list() {
        List<TransportadorModel> response = new ArrayList<>();
        TransportadorModel transportador;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                transportador = doc.toObject(TransportadorModel.class);
                //Arrumar doc.getId
                transportador.setId_Transportador(doc.getId());
                response.add(transportador);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(TransportadorModel transportador) {
        Map<String, Object> docData = getDocData(transportador);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }


    @Override
    public Boolean edit(String id_Transportador, TransportadorModel transportador) {
        Map<String, Object> docData = getDocData(transportador);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Transportador).set(docData);
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id_Transportador) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Transportador).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("Transportador");
    }

    private Map<String, Object> getDocData(TransportadorModel transportador) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id_Transportador", transportador.getId_Transportador());
        docData.put("cnh", transportador.getCnh());
        docData.put("placaVeiculo", transportador.getPlacaVeiculo());
        docData.put("modeloVeiculo", transportador.getModeloVeiculo());
        docData.put("documentoVeiculo", transportador.getDocumentoVeiculo());
        docData.put("anoVeiculo", transportador.getAnoVeiculo());
        docData.put("chavePix", transportador.getChavePix());
        return docData;
    }
    
}

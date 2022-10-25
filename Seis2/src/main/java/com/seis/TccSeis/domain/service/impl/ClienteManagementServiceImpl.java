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
import com.seis.TccSeis.domain.service.ClienteService;
import com.seis.TccSeis.domain.model.ClienteModel;

/**
 *
 * @author devsys-a
 */
@Service
public class ClienteManagementServiceImpl implements ClienteService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<ClienteModel> list() {
        List<ClienteModel> response = new ArrayList<>();
        ClienteModel cliente;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                cliente = doc.toObject(ClienteModel.class);
                cliente.setId(doc.getId());
                response.add(cliente);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(ClienteModel cliente) {
        Map<String, Object> docData = getDocData(cliente);

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
    public Boolean edit(String id, ClienteModel cliente) {
        Map<String, Object> docData = getDocData(cliente);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
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
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
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
        return firebase.getFirestore().collection("cliente");
    }

    private Map<String, Object> getDocData(ClienteModel cliente) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", cliente.getId());
        docData.put("nome", cliente.getNome());
        docData.put("localizac", cliente.getLocalizacao());
        return docData;
    }
    
}

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
import com.seis.TccSeis.domain.model.DestinatarioModel;
import com.seis.TccSeis.domain.repository.DestinatarioService;

        

/**
 *
 * @author devsys-a
 */
@Service
public class DestinatarioManagementServiceImpl implements DestinatarioService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<DestinatarioModel> list() {
        List<DestinatarioModel> response = new ArrayList<>();
        DestinatarioModel destinatario;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                destinatario = doc.toObject(DestinatarioModel.class);
                //Arrumar doc.getId
                destinatario.setId_Destinatario(doc.getId());
                response.add(destinatario);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(DestinatarioModel destinatario) {
        Map<String, Object> docData = getDocData(destinatario);

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
    public Boolean edit(String id_Destinatario, DestinatarioModel destinatario) {
        Map<String, Object> docData = getDocData(destinatario);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Destinatario).set(docData);
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
    public Boolean delete(String id_Destinatario) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Destinatario).delete();
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
        return firebase.getFirestore().collection("Destinatario");
    }

    private Map<String, Object> getDocData(DestinatarioModel destinatario) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id_Destinatario", destinatario.getId_Destinatario());
        docData.put("nome", destinatario.getNome());
        docData.put("email", destinatario.getEmail());
        docData.put("telefone", destinatario.getTelefone());
        docData.put("cpf", destinatario.getCpf());
        docData.put("cidade", destinatario.getCidade());
        docData.put("uf", destinatario.getUf());
        docData.put("latitude", destinatario.getLatitude());
        docData.put("longitude", destinatario.getLongitude());
        return docData;
    }
    
}

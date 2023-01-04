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
import com.seis.TccSeis.domain.model.ColaboradorModel;
import com.seis.TccSeis.domain.repository.ColaboradorService;

        

/**
 *
 * @author devsys-a
 */
@Service
public class ColaboradorManagementServiceImpl implements ColaboradorService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<ColaboradorModel> list() {
        List<ColaboradorModel> response = new ArrayList<>();
        ColaboradorModel colaborador;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                colaborador = doc.toObject(ColaboradorModel.class);
                //Arrumar doc.getId
                colaborador.setId_Colaborador(doc.getId());
                response.add(colaborador);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(ColaboradorModel colaborador) {
        Map<String, Object> docData = getDocData(colaborador);

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
    public Boolean edit(String id_Colaborador, ColaboradorModel colaborador) {
        Map<String, Object> docData = getDocData(colaborador);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Colaborador).set(docData);
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
    public Boolean delete(String id_Colaborador) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Colaborador).delete();
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
        return firebase.getFirestore().collection("Colaborador");
    }

    private Map<String, Object> getDocData(ColaboradorModel colaborador) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id_Colaborador", colaborador.getId_Colaborador());
        docData.put("nome", colaborador.getNome());
        docData.put("email", colaborador.getEmail());
        docData.put("telefone", colaborador.getTelefone());
        docData.put("cpf", colaborador.getCpf());
        docData.put("cidade", colaborador.getCidade());
        docData.put("uf", colaborador.getUf());
        docData.put("latitude", colaborador.getLatitude());
        docData.put("longitude", colaborador.getLongitude());
        docData.put("tipo", colaborador.getTipo());
        return docData;
    }
    
}

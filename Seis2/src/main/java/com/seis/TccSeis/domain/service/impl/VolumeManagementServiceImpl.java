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
import com.seis.TccSeis.domain.model.VolumeModel;
import com.seis.TccSeis.domain.service.VolumeService;

/**
 *
 * @author devsys-a
 */
@Service
public class VolumeManagementServiceImpl implements VolumeService {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<VolumeModel> list() {
        List<VolumeModel> response = new ArrayList<>();
        VolumeModel volume;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                volume = doc.toObject(VolumeModel.class);
                //Arrumar doc.getId
                volume.setId_Volume(doc.getId());
                response.add(volume);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(VolumeModel volume) {
        Map<String, Object> docData = getDocData(volume);

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
    public Boolean edit(String id_Volume, VolumeModel volume) {
        Map<String, Object> docData = getDocData(volume);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Volume).set(docData);
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
    public Boolean delete(String id_Volume) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Volume).delete();
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
        return firebase.getFirestore().collection("Volume");
    }

    private Map<String, Object> getDocData(VolumeModel volume) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", volume.getId_Volume());
        docData.put("peso", volume.getPeso());
        docData.put("altura", volume.getAltura());
        docData.put("largura", volume.getLargura());
        docData.put("profundidade", volume.getProfundidade());
        docData.put("destino", volume.getDestino());
        docData.put("origem", volume.getOrigem());
        docData.put("status", volume.getStatus());
        docData.put("remetente", volume.getRemetente());
        docData.put("destinatario", volume.getDestinatario());
        docData.put("transportador", volume.getTransportador());
        docData.put("baseOrigem", volume.getBaseOrigem());
        docData.put("baseColeta", volume.getBaseColeta());
        return docData;
    }
    
}

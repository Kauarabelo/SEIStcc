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
import com.seis.TccSeis.domain.service.loginService2;
import com.seis.TccSeis.domain.model.loginModel2;

/**
 *
 * @author devsys-a
 */
@Service
public class loginManagementServiceImpl2 implements loginService2 {

    @Autowired
    private FirebaseInitializer firebase;

    @Override
    public List<loginModel2> list() {
        List<loginModel2> response = new ArrayList<>();
        loginModel2 login;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                login = doc.toObject(loginModel2.class);
                //Arrumar doc.getId
                login.setEmail(doc.getId());
                response.add(login);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(loginModel2 login) {
        Map<String, Object> docData = getDocData(login);

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
    public Boolean edit(String id_Login, loginModel2 login) {
        Map<String, Object> docData = getDocData(login);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Login).set(docData);
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
    public Boolean delete(String id_Login) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Login).delete();
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
        return firebase.getFirestore().collection("Login");
    }

    private Map<String, Object> getDocData(loginModel2 login) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("email", login.getEmail());
        docData.put("password", login.getPassword());
        return docData;
    }
    
}

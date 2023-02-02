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
import com.seis.TccSeis.domain.model.LoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.seis.TccSeis.domain.service.LoginService;

/**
 *
 * @author devsys-a
 */
@Service
public class LoginManagementServiceImpl implements LoginService {

    @Autowired
    private FirebaseInitializer firebase;

    Logger logger = LoggerFactory.getLogger(LoginManagementServiceImpl.class);

    @Override
    public List<LoginModel> list() {
        List<LoginModel> response = new ArrayList<>();
        LoginModel login;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {

                login = doc.toObject(LoginModel.class);
                login.setId(doc.getId());
                login.setEmail(doc.getString("email"));
                login.setPassword(doc.getString("password"));
                response.add(login);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
   }

    public LoginModel getLogin(LoginModel dadosLogin) {
        List<LoginModel> response = new ArrayList<>();

        LoginModel loginCarga;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection()
                .whereEqualTo("email", dadosLogin.getEmail())
                .whereEqualTo("password", dadosLogin.getPassword())
                .get();

        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {

                loginCarga = doc.toObject(LoginModel.class);
                loginCarga.setId(doc.getId());
                loginCarga.setEmail(doc.getString("email"));
                loginCarga.setPassword(doc.getString("password"));
                response.add(loginCarga);
            }
            if (null != response.get(0)) {
                return response.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean add(LoginModel login) {
        Map<String, Object> docData = getDocData(login);

        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);

        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean edit(String id_Login, LoginModel login) {
        Map<String, Object> docData = getDocData(login);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id_Login).set(docData);
        try {
            if (null != writeResultApiFuture.get()) {
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
            if (null != writeResultApiFuture.get()) {
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

    private Map<String, Object> getDocData(LoginModel login) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("email", login.getEmail());
        docData.put("password", login.getPassword());
        return docData;
    }

}

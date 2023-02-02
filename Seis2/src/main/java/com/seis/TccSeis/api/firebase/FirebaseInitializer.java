/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seis.TccSeis.api.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-a
 */

@Service
public class FirebaseInitializer {
    
    @PostConstruct
    private  void  iniFirestore() throws IOException {

        FileInputStream serviceAccount = new FileInputStream("./applicationProperties.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://seis-7c7c6-default-rtdb.firebaseio.com/")
                .build();     

        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
        }
    }
    

    public Firestore getFirestore(){
        return FirestoreClient.getFirestore();
    }
}



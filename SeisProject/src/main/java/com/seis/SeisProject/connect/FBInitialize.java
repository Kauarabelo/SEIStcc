package com.seis.SeisProject.connect;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("./serviceaccount.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://seistcc-default-rtdb.firebaseio.com\n")
                    .build();

            FirebaseApp.initializeApp(options);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
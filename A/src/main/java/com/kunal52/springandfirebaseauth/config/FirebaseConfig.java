package com.kunal52.springandfirebaseauth.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.kunal52.springandfirebaseauth.auth.models.SecurityProperties;
import java.io.FileInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class FirebaseConfig {

    @Autowired
    SecurityProperties secProps;

    @Primary
    @Bean
    @PostConstruct
    public void firebaseInit() throws IOException {
  

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

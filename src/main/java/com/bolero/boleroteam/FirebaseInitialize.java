package com.bolero.boleroteam;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
@Service
public class FirebaseInitialize {
    @PostConstruct
    public void initialize(){
        try{
            FileInputStream serviceAccount =
                    new FileInputStream("./databasezingmp3-firebase-adminsdk.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://databasezingmp3.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

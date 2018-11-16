package com.example.demo.firebase;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseOpenHelper {
	
	private FirebaseAuth defaultAuth;
	private FirebaseDatabase defaultDatabase;
	
	private FirebaseOpenHelper() throws IOException {
		FileInputStream serviceAccount = new FileInputStream("./poecseptembre2018-firebase-adminsdk.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://poecseptembre2018.firebaseio.com").build();

		FirebaseApp.initializeApp(options);
	
		defaultAuth = FirebaseAuth.getInstance(FirebaseApp.getInstance());
		defaultDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance());
	}

	private static FirebaseOpenHelper INSTANCE = null;

	public static synchronized FirebaseOpenHelper getInstance() throws IOException {
		if (INSTANCE == null) {
			INSTANCE = new FirebaseOpenHelper();
		}
		return INSTANCE;
	}
	
	public FirebaseDatabase getDatabase() {
		return defaultDatabase;
	}
}

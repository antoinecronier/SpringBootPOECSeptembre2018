package com.example.demo.firebase;

import java.io.IOException;
import java.util.concurrent.Executor;

import com.example.demo.firebase.models.Notification;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public class FirebaseNotificationObserver {
	
	Notification notification;
	
	private FirebaseNotificationObserver() throws IOException {
		this.notification = new Notification("notification",0);
		firebaseNotificationsObserver(this.notification);
	}

	private static FirebaseNotificationObserver INSTANCE = null;

	public static synchronized FirebaseNotificationObserver getInstance() throws IOException {
		if (INSTANCE == null) {
			INSTANCE = new FirebaseNotificationObserver();
		}
		return INSTANCE;
	}
	
	private void firebaseNotificationsObserver(Notification notification) throws IOException {
		FirebaseOpenHelper.getInstance().getDatabase().getReference("/notifications").setValueAsync(notification).addListener(new Runnable() {
			
			public void run() {
				System.out.println("run");
			}
		}, new Executor() {
			
			public void execute(Runnable command) {
				System.out.println("execute");
			}
		});;
		FirebaseOpenHelper.getInstance().getDatabase().getReference("/notifications").addChildEventListener(new ChildEventListener() {
			
			public void onChildRemoved(DataSnapshot snapshot) {
				System.out.println("removed "+snapshot.getKey());
			}
			
			public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
				System.out.println("moved "+snapshot.getKey());
			}
			
			public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
				System.out.println("changed "+snapshot.getKey());
				if (snapshot.getKey().equals("name")) {
					FirebaseNotificationObserver.this.notification.setName(snapshot.getValue().toString());
				}
				if (snapshot.getKey().equals("clicks")) {
					Integer clicks = Integer.valueOf(snapshot.getValue().toString());
					FirebaseNotificationObserver.this.notification.setClicks(clicks);
				}	
			}
			
			public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
				System.out.println("Added "+snapshot.getKey());
			}
			
			public void onCancelled(DatabaseError error) {
				System.out.println("Error");
			}
		});
	}

	public Notification getNotification() {
		return this.notification;
	}
}

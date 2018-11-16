package com.example.demo.firebase.controllers;

import java.io.IOException;
import java.util.concurrent.Executor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.firebase.FirebaseNotificationObserver;
import com.example.demo.firebase.FirebaseOpenHelper;
import com.example.demo.firebase.models.Notification;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

@Controller
@RequestMapping("/firebase")
public class FirebaseController {

	@RequestMapping(value= {"","/","/index"})
	public String index(Model model) throws IOException {
		
		model.addAttribute("notification",FirebaseNotificationObserver.getInstance().getNotification());
		
		return "/firebase/index";
	}
}

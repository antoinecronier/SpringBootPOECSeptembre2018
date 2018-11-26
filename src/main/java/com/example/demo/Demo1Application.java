package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.security.services.PreLaunchService;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class Demo1Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Demo1Application.class, args);
	}

	@Autowired
	PreLaunchService service;
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return new CommandLineRunner() {
			public void run(String... args) throws Exception {
				service.createFirstAdmin();
			}
		};
    }
	
}

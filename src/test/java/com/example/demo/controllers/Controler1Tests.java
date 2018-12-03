package com.example.demo.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.Controler1;
import com.example.demo.utils.ClassUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@PropertySource(value= {"test.application.properties"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Controler1Tests {

	@Autowired
	private Controler1 controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void navigation() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void canLogout() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<a href=\"/logout\">Logout<a/>")));
	}
	
	@Test
	public void canRegister() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<a href=\"/registration\">Register<a/>")));
	}
	
	@Test
	public void canNavigateToAdminModels() throws Exception {
		
		for (Class<?> klazz : ClassUtils.getClasses("com.example.demo.models")) {
			this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("<a href=\"/"+klazz.getSimpleName().toLowerCase()+"s")));
		}
		
	}
	
	@Test
	public void cookieGenerated() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(cookie().exists("myCookie"));
	}
}

package com.example.demo.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.Inheritance;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.database.RoleRepository;
import com.example.demo.database.UserRepository;
import com.example.demo.models.User;
import com.example.demo.security.controllers.LoginController;
import com.example.demo.security.services.PreLaunchService;
import com.example.demo.security.services.UserDetailsServiceImpl;
import com.example.demo.utils.LoginDatabaseUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@PropertySource(value= {"test.application.properties"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private MockHttpServletRequest request;

	private MockMvc mockMvc;
	
	private Boolean notInit = true;
	
	@Autowired
	LoginDatabaseUtils loginDatabaseUtils;
	
	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilters(springSecurityFilterChain)
				.build();
		if (notInit) {
			loginDatabaseUtils.CreateAdminAndUser();
			notInit = false;
		}
	}

//	@After
//	public void deferal() {
//		if (notInit) {
//			loginDatabaseUtils.RemoveAdminAndUser();
//			notInit = false;
//		}
//	}

	@Test
	public void testAnonymous() throws Exception {
		mockMvc.perform(get("/users/index")).andExpect(status().is4xxClientError());
	}

	@Test
	public void verifiesLoginPageLoadsRedirect() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("users/index"))
				.andExpect(MockMvcResultMatchers.model().hasNoErrors())
				.andExpect(MockMvcResultMatchers.view().name("redirect:/login"))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection());
	}
	
	@Test
    public void signedInAsUser() throws Exception {

    	UsernamePasswordAuthenticationToken principal = userDetailsServiceImpl.autologin("user@site.com", "greatUser");

        MockHttpSession session = new MockHttpSession();
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, 
                new MockSecurityContext(principal));

        mockMvc
            .perform(
                    get("/users/")
                    .session(session))
            .andExpect(status().isOk());
        
        mockMvc
        .perform(
                get("/users/edit")
                .session(session))
        .andExpect(status().is3xxRedirection());
        
        assertTrue(principal.isAuthenticated());
		assertEquals(principal.getName(), "user@site.com");
		assertEquals(((GrantedAuthority)principal.getAuthorities().toArray()[0]).getAuthority(),"ROLE_USER");
    } 
	
	public static class MockSecurityContext implements SecurityContext {

        private static final long serialVersionUID = -1386535243513362694L;

        private Authentication authentication;

        public MockSecurityContext(Authentication authentication) {
            this.authentication = authentication;
        }

        @Override
        public Authentication getAuthentication() {
            return this.authentication;
        }

        @Override
        public void setAuthentication(Authentication authentication) {
            this.authentication = authentication;
        }
    }
}

package com.example.demo.security.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.services.RoleService;
import com.example.demo.services.UserService;

@Service
public class PreLaunchService {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private RoleService serviceRole;

	@Autowired
	private UserService serviceUser;

	public void createFirstAdmin() {
		User user = new User("admin@site.com", "admin", 1, "myAdmin", "forSite");
		createUserWithRole(user,"ADMIN");
	}
	
	@Transactional()
	public void createUserWithRole(User user, String roleName) {

		Role role = null;
		if ((role = this.serviceRole.findByName(roleName)) == null) {
			role = new Role(roleName);
			this.serviceRole.save(role);
		}

		User userTest = null;
		if ((userTest = this.serviceUser.findByEmail(user.getEmail())) == null
				|| userTest.getRoles().size() == 0) {
			user.getRoles().add(role);
			this.serviceUser.save(user);
		}
	}

	@Transactional()
	public void insertSessionDatabaseItems() throws SQLException {
		Connection connection = dataSource.getConnection();
		
		ResultSet rs = connection.prepareStatement("SHOW TABLES").executeQuery();
		
		Boolean haveTable = false;
		while (rs.next()) {
			if (rs.getString(1).equals("SPRING_SESSION")) {
				haveTable = true;
			}
		}

		if (!haveTable) {
			connection.createStatement()
					.execute("CREATE TABLE SPRING_SESSION (" + 
							"	PRIMARY_ID CHAR(36) NOT NULL," + 
							"	SESSION_ID CHAR(36) NOT NULL," + 
							"	CREATION_TIME BIGINT NOT NULL," + 
							"	LAST_ACCESS_TIME BIGINT NOT NULL," + 
							"	MAX_INACTIVE_INTERVAL INT NOT NULL," + 
							"	EXPIRY_TIME BIGINT NOT NULL," + 
							"	PRINCIPAL_NAME VARCHAR(100)," + 
							"	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)" + 
							") ENGINE=InnoDB ROW_FORMAT=DYNAMIC;");
					connection.createStatement()
					.execute("CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);"); 
							connection.createStatement()
					.execute("CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);");
							connection.createStatement()
					.execute("CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);");
					connection.createStatement()
						.execute("CREATE TABLE SPRING_SESSION_ATTRIBUTES (" + 
							"	SESSION_PRIMARY_ID CHAR(36) NOT NULL," + 
							"	ATTRIBUTE_NAME VARCHAR(200) NOT NULL," + 
							"	ATTRIBUTE_BYTES BLOB NOT NULL," + 
							"	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME)," + 
							"	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE" + 
							") ENGINE=InnoDB ROW_FORMAT=DYNAMIC;");
		}
		
		connection.close();
	}
}

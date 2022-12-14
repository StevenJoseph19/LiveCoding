package com.mycompany.tddjunit5.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.mycompany.tddjunit5.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DatabaseAccessTest {

	@Mock
	Database database;

	private Credentials credentials = new Credentials("user", "password");

	@Test
	void testUserSuccessfullLogin() {

		when(database.login(credentials)).thenReturn(true);
		Credentials sameCredentials = new Credentials("user", "password");
		assertTrue(database.login(sameCredentials));

	}

	@Test
	void testUserFailedLogin() {

		when(database.login(credentials)).thenReturn(true);
		Credentials otherCredentials = new Credentials("user", "password");
		otherCredentials.setUsername("otherUser");
		otherCredentials.setPassword("otherPassword");
		assertNotEquals(credentials.getUsername(),otherCredentials.getUsername());
		assertNotEquals(credentials.getPassword(),otherCredentials.getPassword());
		assertNotEquals(credentials.hashCode(),otherCredentials.hashCode());
		assertFalse(database.login(otherCredentials));

	}

}

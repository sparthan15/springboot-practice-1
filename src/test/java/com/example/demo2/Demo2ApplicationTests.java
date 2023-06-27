package com.example.demo2;

import com.example.demo2.phonebook.controller.PhonebookController;
import com.example.demo2.phonebook.controller.model.in.NewContact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class Demo2ApplicationTests {

	@Autowired
	private PhonebookController phonebookController;

	@Autowired
	private DataSource dataSource;
	@Test
	void contextLoads() {
	}

	@Test
	void canCreateNewContact(){
		boolean result = phonebookController.createContact(new NewContact("Charlie", "Gamboa", "3021301230"));
		Assertions.assertTrue(result);
	}

	@Test
	void givenTheDatasourceAvailableWhenAccessDetailsThenExpectDetails() throws SQLException {
		Assertions.assertEquals(dataSource.getClass().getName(), "com.zaxxer.hikari.HikariDataSource");
		Assertions.assertEquals(dataSource.getConnection().getMetaData().getDatabaseProductName(), "H2");
	}

}

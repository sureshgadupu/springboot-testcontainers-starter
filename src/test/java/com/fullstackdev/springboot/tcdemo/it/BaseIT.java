package com.fullstackdev.springboot.tcdemo.it;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@Testcontainers
public class BaseIT {
	
	@Autowired
	protected TestRestTemplate testRestTemplate ;
	
	
	
	
		
//	@Container
//	private static PostgreSQLContainer<?> postgresDB = new PostgreSQLContainer<>(PostgreSQLContainer.IMAGE)
//																		.withDatabaseName("testdb")
//																		.withUsername("postgres")
//																		.withPassword("secret")
//																		.withInitScript("ddl.sql");
	
//	@DynamicPropertySource
//	public static void properties(DynamicPropertyRegistry registry) {
//		
//		registry.add("spring.datasource.url", postgresDB::getJdbcUrl);		
//		registry.add("spring.datasource.username", postgresDB::getUsername);
//		registry.add("spring.datasource.password", postgresDB::getPassword);
//		
//	}

}

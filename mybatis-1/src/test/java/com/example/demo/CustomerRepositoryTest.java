package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository repo;
	
	@Test
	public void insert() {
		Customer cust = new Customer("길동","홍");
		Customer result = repo.save(cust);
		assertThat(result.getFirstName()).isEqualTo("길동");
	}
}

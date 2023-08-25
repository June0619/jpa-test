package com.example.demo;

import com.example.demo.domain.TestEntity;
import com.example.demo.service.TransactionRollbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.persistence.EntityManager;

@SpringBootApplication
public class JpaTestApplication {

	@Autowired private EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}

	//event listener
//	@EventListener
	public void onApplicationEvent(ApplicationReadyEvent event) {
		TestEntity testEntity = em.find(TestEntity.class, 1L);
		System.out.println(testEntity);
	}

}

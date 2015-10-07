package com.charlie.pw.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.charlie.pw.service.ProductRepository;
import com.charlie.pw.service.ProductService;
import com.charlie.pw.vo.Product;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	
	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void run(String... args) throws Exception {

		Product p = new Product();
        p.setName("Charlie SIU");
        p.setId("97259741");
        p.setBrand("JPMC");
        p.setCategory("Banking");
        p.addPriceWatch("ABC", 100);
        //PriceWatchDAO pwDao = new PriceWatchDAO();
        //pwDao.addPriceWatch(p);
		

		// save a couple of customers

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Product prod : repository.findAll()) {
			System.out.println(prod);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByName("Charlie"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Product prod: repository.findByBrand("JPMC")) {
			System.out.println(prod);
		}

	}
	
}
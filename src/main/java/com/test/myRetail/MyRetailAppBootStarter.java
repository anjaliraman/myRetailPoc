package com.test.myRetail;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.test.myRetail.dao.MyRetailRepository;
import com.test.myRetail.model.Price;
import com.test.myRetail.model.Product;

@SpringBootApplication
public class MyRetailAppBootStarter {

	public static void main(String[] args) {
		SpringApplication.run(MyRetailAppBootStarter.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(MyRetailRepository repository) {
	    return (args) -> {
	        // save a couple of customers
	        repository.save(new Product(Long.valueOf(15117729),"Trolls(Blu Ray)",new Price(17.99f,"USD")));
	        repository.save(new Product(Long.valueOf(16483589),"Frozen(Blu Ray)",new Price(19.99f,"USD")));
	        repository.save(new Product(Long.valueOf(16696652),"Sing",new Price(20.25f,"USD")));
	        repository.save(new Product(Long.valueOf(16752456),"Magadaskar",new Price(17.99f,"USD")));
	        repository.save(new Product(Long.valueOf(15643793),"Moana(Blu Ray)",new Price(17.99f,"USD")));
	    };
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	

}

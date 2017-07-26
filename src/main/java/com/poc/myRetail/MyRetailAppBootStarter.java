package com.poc.myRetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.poc.myRetail.dao.MyRetailRepository;
import com.poc.myRetail.dto.Product;
import com.poc.myRetail.model.ProductPriceDao;

@SpringBootApplication
@ComponentScan(basePackages={"com.poc.myRetail"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, 
		HibernateJpaAutoConfiguration.class,
		JpaRepositoriesAutoConfiguration.class})
public class MyRetailAppBootStarter implements CommandLineRunner{

	@Autowired
	MyRetailRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(MyRetailAppBootStarter.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
			System.out.println("In here");
			repository.deleteAll();
	        // save a couple of customers
	        repository.save(new ProductPriceDao(Long.valueOf(15117729),17.99,"USD"));
	        repository.save(new ProductPriceDao(Long.valueOf(16483589),19.99,"USD"));
	        repository.save(new ProductPriceDao(Long.valueOf(16696652),20.25,"USD"));
	        repository.save(new ProductPriceDao(Long.valueOf(16752456),27.99,"USD"));
	        repository.save(new ProductPriceDao(Long.valueOf(15643793),47.99,"USD"));
	        System.out.println(repository.findAll());
	 };
	
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
}

package com.poc.myRetail.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.poc.myRetail.model.ProductPriceDao;

@Repository
public interface MyRetailRepository extends MongoRepository<ProductPriceDao, Long> {
	
	
}

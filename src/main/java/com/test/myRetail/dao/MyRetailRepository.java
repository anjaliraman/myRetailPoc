package com.test.myRetail.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.test.myRetail.model.ProductPriceDao;

@Repository
public interface MyRetailRepository extends MongoRepository<ProductPriceDao, Long> {
	
	
}

package com.test.myRetail.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.myRetail.model.Product;

public interface MyRetailRepository extends CrudRepository<Product, Long>{

}

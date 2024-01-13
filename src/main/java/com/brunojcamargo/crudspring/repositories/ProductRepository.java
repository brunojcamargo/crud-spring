package com.brunojcamargo.crudspring.repositories;

import com.brunojcamargo.crudspring.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

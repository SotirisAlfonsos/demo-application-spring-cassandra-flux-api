package nl.zwennesm.repository;

import nl.zwennesm.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ProductRepository extends ReactiveCrudRepository<Product, String> {}

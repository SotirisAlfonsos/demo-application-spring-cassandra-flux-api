package nl.zwennesm.repository;

import nl.zwennesm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Mono<Product> save(Product product) {
        return repository.save(product);
    }

    public Mono<Product> findById(String sku) {
        return repository.findById(sku);
    }

    public Flux<Product> findAll() {
        return  repository.findAll();
    }
}

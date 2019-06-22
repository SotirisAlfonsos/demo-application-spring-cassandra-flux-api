package nl.zwennesm.controller;

import nl.zwennesm.model.Product;
import nl.zwennesm.repository.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/recommend/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(path = "/add")
    public Mono<Product> put(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping(path = "/{sku}")
    public Mono<Product> get(@PathVariable("sku") String sku) {
        return service.findById(sku);
    }

    @PostMapping(path = "/{sku}")
    public Mono<Product> update(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping(path = "/all")
    public Flux<Product> all() { return this.service.findAll(); }
}

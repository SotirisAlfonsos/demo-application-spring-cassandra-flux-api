package nl.zwennesm.controller;

import nl.zwennesm.RecommendationException;
import nl.zwennesm.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@RestController
@RequestMapping("/recommend/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public Mono<ServerResponse> get(@PathVariable("id") String id) {
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(fromObject(service.findById(id)))
                .onErrorResume(RecommendationException.class, e -> ServerResponse.notFound().build());
    }

    @GetMapping("/test")
    public ResponseEntity serverResponseMono() {
        return ResponseEntity
                .ok()
                .contentType(APPLICATION_JSON)
                .body(Flux.just("test"));
    }
}

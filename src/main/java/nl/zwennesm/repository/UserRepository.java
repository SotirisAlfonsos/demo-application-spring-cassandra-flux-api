package nl.zwennesm.repository;

import nl.zwennesm.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface UserRepository extends ReactiveCrudRepository<User, String> {}

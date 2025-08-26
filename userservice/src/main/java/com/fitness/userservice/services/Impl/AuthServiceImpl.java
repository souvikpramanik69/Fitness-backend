package com.fitness.userservice.services.Impl;

import com.fitness.userservice.enums.Roles;
import com.fitness.userservice.models.Users;
import com.fitness.userservice.payload.UserPayload;
import com.fitness.userservice.repositories.UserRepositories;
import com.fitness.userservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepositories repositories;

    public Mono<Users> register(UserPayload payload) {
        return Mono.fromCallable(() -> repositories.findByEmail(payload.getEmail()))
                .subscribeOn(Schedulers.boundedElastic())
                .flatMap(optionalUser -> {
                    if (optionalUser.isPresent()) {
                        return Mono.<Users>empty(); // User exists
                    }
                    Users user = new Users();
                    user.setEmail(payload.getEmail());
                    user.setFirstName(payload.getFirstName());
                    user.setLastName(payload.getLastName());
                    user.setPassword(payload.getPassword());
                    user.setRole(Roles.USER);
                    return Mono.fromCallable(() -> repositories.save(user))
                            .subscribeOn(Schedulers.boundedElastic());
                });
    }
}
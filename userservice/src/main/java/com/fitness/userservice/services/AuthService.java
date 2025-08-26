package com.fitness.userservice.services;

import com.fitness.userservice.models.Users;
import com.fitness.userservice.payload.UserPayload;
import reactor.core.publisher.Mono;

public interface AuthService {
    public Mono<Users> register(UserPayload payload);


}

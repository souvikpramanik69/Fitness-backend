package com.fitness.aiservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebClient;


    public Boolean validUser(String userId){
    return userServiceWebClient.get().uri("api/user/{userId}/validate",userId).retrieve().bodyToMono(Boolean.class).block();
}
}

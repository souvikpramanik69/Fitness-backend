package com.fitness.activityservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebClient;

    public Mono<Boolean> validateUser(String userId){
         try{

             return userServiceWebClient.get()
                     .uri("/api/user/{userId}/validate", userId)
                     .retrieve().bodyToMono(Boolean.class).onErrorResume(WebClientResponseException.class, e -> {
                         if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                             return Mono.error(new RuntimeException("User doesn't exist"));
                         } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                             return Mono.error(new RuntimeException("Invalid User"));
                         } else {
                             return Mono.error(e);
                         }
                     });
         }
         catch (WebClientResponseException e){
             System.err.println("Error in User Validation Service " + e);
             if(e.getStatusCode() == HttpStatus.NOT_FOUND){
                 throw  new RuntimeException("User doesn't exist");
             }
             else if(e.getStatusCode() == HttpStatus.BAD_REQUEST){
                 throw  new RuntimeException("Invalid User");
             }

         }

        return null;
    }

}

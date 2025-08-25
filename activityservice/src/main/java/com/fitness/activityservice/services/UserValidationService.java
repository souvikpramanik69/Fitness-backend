package com.fitness.activityservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId){
         try{

             return userServiceWebClient.get()
                     .uri("/api/user/{userId}/validate", userId)
                     .retrieve().bodyToMono(Boolean.class).block();
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
        return false;
    }

}

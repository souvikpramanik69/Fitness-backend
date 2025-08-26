package com.fitness.userservice.controllers;

import com.fitness.userservice.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    public Mono<ServerResponse> userValidateHandler(ServerRequest request){
        String userId = request.pathVariable("userId");
        Mono<Boolean> publisher = Mono.just(userService.existByUserId(userId));
        return ServerResponse.ok().body(publisher,Boolean.class);

    }

}

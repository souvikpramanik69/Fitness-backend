package com.fitness.userservice.controllers;

import com.fitness.userservice.Reponse.ApiResponse;
import com.fitness.userservice.dto.UserDto;
import com.fitness.userservice.enums.Status;
import com.fitness.userservice.mapper.UserMapper;
import com.fitness.userservice.models.Users;
import com.fitness.userservice.payload.UserPayload;
import com.fitness.userservice.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    public Mono<ServerResponse> registerController(ServerRequest request) {
        return request.bodyToMono(UserPayload.class)
                .flatMap(payload -> authService.register(payload)
                        .flatMap(result -> {
                            ApiResponse<UserDto, String> response = new ApiResponse<>(
                                    Status.SUCCESS, 201, "User registered successfully", UserMapper.mapToDto(result)
                            );
                            return ServerResponse.created(URI.create("/api/users/" + result.getId()))
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(response);
                        })
                        .switchIfEmpty(Mono.defer(() -> {
                            ApiResponse<UserDto, String> response = new ApiResponse<>(
                                    Status.ERROR, 409, "User already exists", null
                            );
                            return ServerResponse.status(409) // Conflict status for user already exists
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .bodyValue(response);
                        }))
                )
                .onErrorResume(e -> {
                    ApiResponse<UserDto, String> response = new ApiResponse<>(
                            Status.ERROR, 400, "Registration failed: " + e.getMessage(), null
                    );
                    return ServerResponse.badRequest()
                            .contentType(MediaType.APPLICATION_JSON)
                            .bodyValue(response);
                });
    }

}
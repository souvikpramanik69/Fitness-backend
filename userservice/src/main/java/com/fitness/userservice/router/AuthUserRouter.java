package com.fitness.userservice.router;

import com.fitness.userservice.controllers.AuthController;
import com.fitness.userservice.controllers.UserController;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

@Configuration
@RequiredArgsConstructor
public class AuthUserRouter {

    private final UserController userController;
    private final AuthController authController;

    @Bean
    RouterFunction<ServerResponse> userRouter(){
        return RouterFunctions.route(RequestPredicates.GET("/api/user/{userId}/validate"),userController::userValidateHandler);
    }

    @Bean
    RouterFunction<ServerResponse> authRouter(){
        return RouterFunctions.route(RequestPredicates.POST("/api/auth/register"),authController::registerController);
    }
}

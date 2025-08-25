package com.fitness.userservice.controllers;

import com.fitness.userservice.services.Impl.AuthServiceImpl;
import com.fitness.userservice.services.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;


    @GetMapping("/user/{id}/validate")
    public ResponseEntity<Boolean> existByUserId(@PathVariable String id){
        return new ResponseEntity<>(userService.existByUserId(id), HttpStatus.OK);
    }

}

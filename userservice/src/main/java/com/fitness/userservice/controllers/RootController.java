package com.fitness.userservice.controllers;

import com.fitness.userservice.Reponse.ApiResponse;
import com.fitness.userservice.enums.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.ObjenesisHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/api")
    public ResponseEntity<ApiResponse<Object,Object>> rootController(){
        ApiResponse<Object,Object> response =
                new ApiResponse<Object,Object>(Status.SUCCESS,200,"Welcome to Fitness User Service");

        return new ResponseEntity<ApiResponse<Object,Object>>(response, HttpStatus.OK);
    }

}

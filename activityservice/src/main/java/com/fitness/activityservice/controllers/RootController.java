package com.fitness.activityservice.controllers;

import com.fitness.activityservice.enums.Status;
import com.fitness.activityservice.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/api")
    public ResponseEntity<ApiResponse<String,Object>> rootController(){
        ApiResponse<String,Object> response;
        try{
           response = new ApiResponse<String,Object>(Status.SUCCESS,200,"Welcome to Actitvity Service");
           return new ResponseEntity<ApiResponse<String, Object>>(response, HttpStatus.OK);
        }catch (Exception e){
            response = new ApiResponse<String,Object>(Status.ERROR,500,e.getMessage());
            return new ResponseEntity<ApiResponse<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

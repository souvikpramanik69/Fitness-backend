package com.fitness.userservice.controllers;

import com.fitness.userservice.Reponse.ApiResponse;
import com.fitness.userservice.dto.UserDto;
import com.fitness.userservice.enums.Status;
import com.fitness.userservice.mapper.UserMapper;
import com.fitness.userservice.models.Users;
import com.fitness.userservice.payload.UserPayload;
import com.fitness.userservice.services.Impl.AuthServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDto, String>> register(@Valid @RequestBody UserPayload payload){
      ApiResponse<UserDto, String> response;
    try{
        Users result = authService.register(payload);
        if(result != null){
           response = new ApiResponse<UserDto, String>(Status.SUCCESS,201,"User Registered Successfully", UserMapper.mapToDto(result));
           return new ResponseEntity<ApiResponse<UserDto,String>>(response, HttpStatus.CREATED);
        }
        else {
            response = new ApiResponse<UserDto, String>(Status.ERROR,409,"User Already Exist");
            return new ResponseEntity<ApiResponse<UserDto,String>>(response, HttpStatus.CONFLICT);
        }
    }catch (Exception e){
        response = new ApiResponse<UserDto, String>(Status.ERROR,500,e.getMessage());
        return new ResponseEntity<ApiResponse<UserDto,String>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }










}

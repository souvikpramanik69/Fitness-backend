package com.fitness.userservice.mapper;

import com.fitness.userservice.dto.UserDto;
import com.fitness.userservice.models.Users;

public class UserMapper {

    public static UserDto mapToDto(Users user){


        UserDto dto = new UserDto();
           dto.setId(user.getId());
           dto.setEmail(user.getEmail());
           dto.setFirstName(user.getFirstName());
           dto.setLastName(user.getLastName());
           dto.setCreatedAt(user.getCreatedAt());
           dto.setUpdatedAt(user.getUpdatedAt());
           dto.setRole(user.getRole());
           return dto;

    }


}

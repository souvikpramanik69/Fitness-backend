package com.fitness.userservice.services.Impl;

import com.fitness.userservice.enums.Roles;
import com.fitness.userservice.models.Users;
import com.fitness.userservice.payload.UserPayload;
import com.fitness.userservice.repositories.UserRepositories;
import com.fitness.userservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepositories repositories;

    @Override
    public Users register(UserPayload payload) {
        Optional<Users> isUserExist = repositories.findByEmail(payload.getEmail());
        if(isUserExist.isEmpty()){
            Users user = new Users();
            user.setEmail(payload.getEmail());
            user.setFirstName(payload.getFirstName());
            user.setLastName(payload.getLastName());
            user.setPassword(payload.getPassword());
            user.setRole(Roles.USER);
          return repositories.save(user);
        }
        else {
            return null;
        }

    }



}

package com.fitness.userservice.services.Impl;

import com.fitness.userservice.repositories.UserRepositories;
import com.fitness.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositories repositories;

    public boolean existByUserId(String userId){
        return repositories.existsById(userId);
    }

}

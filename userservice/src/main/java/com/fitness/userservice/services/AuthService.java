package com.fitness.userservice.services;

import com.fitness.userservice.models.Users;
import com.fitness.userservice.payload.UserPayload;

public interface AuthService {
    public Users register(UserPayload payload);


}

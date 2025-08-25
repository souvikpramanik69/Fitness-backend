package com.fitness.userservice.repositories;

import com.fitness.userservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<Users,String> {

    public Optional<Users> findByEmail(String email);

}

package com.fitness.userservice.dto;

import com.fitness.userservice.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
public class UserDto {


    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Roles role = Roles.USER;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

package com.fitness.userservice.payload;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class UserPayload {

    private String firstName;
    private String lastName;
    @Email
    @NotNull(message = "Email can't be empty")
    @Column(unique = true)
    private String email;
    private String password;
    private String role;

}

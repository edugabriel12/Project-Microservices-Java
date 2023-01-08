package com.photopp.api.users.ui.dto;

import com.photopp.api.users.ui.model.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private final String firstName;
    private final String lastName;

    private final String email;


    public UserResponseDto(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }
}

package com.photopp.api.users.ui.dto;

import com.photopp.api.users.ui.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public User getModel() {
        return new User(
                null,
                this.firstName,
                this.lastName,
                this.email,
                this.password);
    }
}

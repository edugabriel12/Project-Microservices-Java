package com.photopp.api.users.ui.controllers;

import com.photopp.api.users.ui.dto.UserDto;
import com.photopp.api.users.ui.dto.UserResponseDto;
import com.photopp.api.users.ui.model.User;
import com.photopp.api.users.ui.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @GetMapping("/status/check")
    public String status() {

        return "Working on port: " + env.getProperty("local.server.port");
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto.getModel());
        UserResponseDto response = new UserResponseDto(createdUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

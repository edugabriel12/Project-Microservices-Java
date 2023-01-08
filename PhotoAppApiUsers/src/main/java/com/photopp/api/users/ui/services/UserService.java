package com.photopp.api.users.ui.services;

import com.photopp.api.users.ui.model.User;
import com.photopp.api.users.ui.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(User user) {
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getEncryptedPassword()));
        return userRepository.save(user);
    }
}

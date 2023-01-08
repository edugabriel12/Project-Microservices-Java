package com.photopp.api.users.ui.repositories;

import com.photopp.api.users.ui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}

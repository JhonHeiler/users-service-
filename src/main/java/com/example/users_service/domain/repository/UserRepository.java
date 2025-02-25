package com.example.users_service.domain.repository;

import com.example.users_service.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByEmail(String email);
    User update(User user);
}
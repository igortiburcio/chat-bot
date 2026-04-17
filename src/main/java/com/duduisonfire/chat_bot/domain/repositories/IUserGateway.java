package com.duduisonfire.chat_bot.domain.repositories;

import java.util.Optional;

import com.duduisonfire.chat_bot.domain.entities.User;

public interface IUserGateway {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findById(String id);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    User save(User user);
}

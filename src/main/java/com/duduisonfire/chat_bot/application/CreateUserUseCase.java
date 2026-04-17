package com.duduisonfire.chat_bot.application;

import com.duduisonfire.chat_bot.domain.entities.User;
import com.duduisonfire.chat_bot.domain.repositories.IUserGateway;

public class CreateUserUseCase {
    private final IUserGateway userGateway;

    public CreateUserUseCase(IUserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User execute(User user) {
        if (userGateway.existsByEmail(user.getEmail())) {
            throw new RuntimeException("User already exists");
        }

        if (userGateway.existsByUsername(user.getUsername())) {
            throw new RuntimeException("User already exists");
        }

        return userGateway.save(user);
    }
}

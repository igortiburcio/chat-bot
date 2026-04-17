package com.duduisonfire.chat_bot.infra.db.gateways;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.duduisonfire.chat_bot.domain.entities.User;
import com.duduisonfire.chat_bot.domain.repositories.IUserGateway;
import com.duduisonfire.chat_bot.infra.db.entities.UserEntity;
import com.duduisonfire.chat_bot.infra.db.repository.UserRepository;

@Repository
public class UserGateway implements IUserGateway {
    private final UserRepository userRepository;

    public UserGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(this::toDomain);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username).map(this::toDomain);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id).map(this::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        return toDomain(userRepository.save(entity));
    }

    private User toDomain(UserEntity entity) {
        if (entity == null)
            return null;

        String username = entity.getUsername();
        String email = entity.getEmail();
        String password = entity.getPassword();
        LocalDate birthDate = entity.getBirthDate();
        String fullName = entity.getFullName();

        return new User(
                username,
                email,
                password,
                birthDate,
                fullName);
    }

    private UserEntity toEntity(User domain) {
        if (domain == null)
            return null;
        UserEntity entity = new UserEntity();

        entity.setUsername(domain.getUsername());
        entity.setEmail(domain.getEmail());
        entity.setPassword(domain.getPassword());
        entity.setBirthDate(domain.getBirthDate());
        entity.setFullName(domain.getFullName());

        return entity;
    }
}

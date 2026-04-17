package com.duduisonfire.chat_bot.infra.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duduisonfire.chat_bot.infra.db.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findById(String id);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}

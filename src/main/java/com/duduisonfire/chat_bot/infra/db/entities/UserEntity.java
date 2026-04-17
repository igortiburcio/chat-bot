package com.duduisonfire.chat_bot.infra.db.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, columnDefinition = "TEXT", name = "username")
    private String username;

    @Column(unique = true, columnDefinition = "TEXT", name = "email")
    private String email;

    @Column(columnDefinition = "TEXT", name = "password")
    private String password;

    @Column(columnDefinition = "DATE", name = "birth_date")
    private LocalDate birthDate;

    @Column(columnDefinition = "TEXT", name = "full_name")
    private String fullName;
}

package com.duduisonfire.chat_bot.domain.entities;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
    public User(String username, String email, String password, LocalDate birthDate, String fullName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.fullName = fullName;
    }

    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String fullName;
}

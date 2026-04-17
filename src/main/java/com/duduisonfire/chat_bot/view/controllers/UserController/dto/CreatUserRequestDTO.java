package com.duduisonfire.chat_bot.view.controllers.UserController.dto;

import java.time.LocalDate;

import lombok.Value;

@Value
public class CreatUserRequestDTO {
    String username;
    String email;
    String password;
    LocalDate birthDate;
    String fullName;
}

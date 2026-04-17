package com.duduisonfire.chat_bot.view.controllers.UserController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duduisonfire.chat_bot.application.CreateUserUseCase;
import com.duduisonfire.chat_bot.domain.entities.User;
import com.duduisonfire.chat_bot.view.controllers.UserController.dto.CreatUserRequestDTO;
import com.duduisonfire.chat_bot.view.controllers.UserController.dto.CreateUserResponseDTO;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping("/create")
    public CreateUserResponseDTO create(@RequestBody CreatUserRequestDTO userRequest) {
        User user = new User(
                userRequest.getUsername(),
                userRequest.getEmail(),
                userRequest.getPassword(),
                userRequest.getBirthDate(),
                userRequest.getFullName());

        User createdUser = createUserUseCase.execute(user);

        CreateUserResponseDTO response = new CreateUserResponseDTO(
                "User created successfully",
                createdUser.getUsername(),
                createdUser.getEmail());

        return response;
    }
}

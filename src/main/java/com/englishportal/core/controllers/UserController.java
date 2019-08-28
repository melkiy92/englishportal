package com.englishportal.core.controllers;

import com.englishportal.core.dto.UserDTO;
import com.englishportal.core.mappers.UserMapper;
import com.englishportal.core.model.User;
import com.englishportal.core.services.servicesInterfaces.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping("/users/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        return userMapper.toDTO(user);
    }

}

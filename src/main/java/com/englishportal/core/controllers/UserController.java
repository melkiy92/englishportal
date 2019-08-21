package com.englishportal.core.controllers;

import com.englishportal.core.dto.RoleDTO;
import com.englishportal.core.dto.UserDTO;
import com.englishportal.core.mappers.UserMapper;
import com.englishportal.core.model.Role;
import com.englishportal.core.model.User;
import com.englishportal.core.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;


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

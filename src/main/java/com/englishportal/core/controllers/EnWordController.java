package com.englishportal.core.controllers;

import com.englishportal.core.dto.EnWordDTO;
import com.englishportal.core.dto.UserDTO;
import com.englishportal.core.mappers.EnWordMapper;
import com.englishportal.core.mappers.UserMapper;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.User;
import com.englishportal.core.services.EnWordService;
import com.englishportal.core.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class EnWordController {

    private final EnWordService enWordService;
    private final EnWordMapper enWordMapper;


    @GetMapping("/en-words/{id}")
    public EnWordDTO sayHello(@PathVariable Long id) {
        EnWord enWord = enWordService.getEnWord(id);
        return enWordMapper.toDTO(enWord);
    }
    /*
    private UserDTO toDTO (User user) {
        Set<RoleDTO> roleDTOS = toDTOs(user.getRoles());
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .roles(roleDTOS)
                .build();
    }
    private Set<RoleDTO> toDTOs (Set<Role> role) {
        return role.stream().map(role1 -> toDTO(role1)).collect(Collectors.toSet());
    }
    private RoleDTO toDTO(Role role) {
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }*/

}

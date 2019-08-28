package com.englishportal.core.dto;

import com.englishportal.core.model.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private Set<RoleDTO> roles;
    private String name;
}

package com.englishportal.core.mappers;

import com.englishportal.core.dto.UserDTO;
import com.englishportal.core.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserDTO toDTO (User user);
}

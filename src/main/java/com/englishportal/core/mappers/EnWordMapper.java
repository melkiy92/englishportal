package com.englishportal.core.mappers;

import com.englishportal.core.dto.EnWordDTO;
import com.englishportal.core.dto.UserDTO;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface EnWordMapper {
    //UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    EnWordDTO toDTO(EnWord enWord);
}

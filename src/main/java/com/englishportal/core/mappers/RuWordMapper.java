package com.englishportal.core.mappers;

import com.englishportal.core.dto.EnWordDTO;
import com.englishportal.core.dto.RuWordDTO;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.RuWord;
import org.mapstruct.Mapper;

@Mapper
public interface RuWordMapper {

    RuWordDTO toDTO(RuWord ruWord);
}

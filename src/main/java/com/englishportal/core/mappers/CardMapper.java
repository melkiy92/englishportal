package com.englishportal.core.mappers;

import com.englishportal.core.dto.CardDTO;
import com.englishportal.core.dto.EnWordDTO;
import com.englishportal.core.model.Card;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper
public interface CardMapper {

      CardDTO toDTO(Card card) throws IOException;
      Card toEntity(CardDTO cardDTO) throws IOException;
}

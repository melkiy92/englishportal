package com.englishportal.core.mappers;

import com.englishportal.core.dto.CardDTO;
import com.englishportal.core.dto.ImageDTO;
import com.englishportal.core.model.Card;
import com.englishportal.core.model.Image;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Mapper
public interface ImageMapper {

    ImageDTO toDTO(Image image) throws IOException;

    Image toEntity(MultipartFile file) throws IOException;
}

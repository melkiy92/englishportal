package com.englishportal.core.services;

import com.englishportal.core.model.Card;
import com.englishportal.core.model.Image;
import com.englishportal.core.repositories.CardRepository;
import com.englishportal.core.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image getImage(Long id) {
        return imageRepository.getById(id);
    }

    @Override
    public Image saveImage(Image image) {
        return imageRepository.save(image);
    }

}

package com.englishportal.core.services.servicesImpl;

import com.englishportal.core.model.Card;
import com.englishportal.core.model.Image;
import com.englishportal.core.repositories.CardRepository;
import com.englishportal.core.repositories.ImageRepository;
import com.englishportal.core.services.ImageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @NonNull
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

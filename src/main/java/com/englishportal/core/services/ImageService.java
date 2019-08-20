package com.englishportal.core.services;


import com.englishportal.core.model.Card;
import com.englishportal.core.model.Image;

public interface ImageService {
    Image getImage(Long id);
    Image saveImage(Image image);
}

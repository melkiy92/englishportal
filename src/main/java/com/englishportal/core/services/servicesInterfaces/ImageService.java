package com.englishportal.core.services.servicesInterfaces;


import com.englishportal.core.model.Image;

import java.util.List;

public interface ImageService {
    Image getImage(Long id);

    Image saveImage(Image image);

    Image updateImage(Long id, Image image);

    void deleteImage(Long id);

}

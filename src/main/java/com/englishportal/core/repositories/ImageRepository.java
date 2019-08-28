package com.englishportal.core.repositories;

import com.englishportal.core.model.Card;
import com.englishportal.core.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {

    Image getById(Long id);

    List<Image> findAll();

}

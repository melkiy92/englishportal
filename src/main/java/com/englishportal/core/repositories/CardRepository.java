package com.englishportal.core.repositories;

import com.englishportal.core.model.Card;
import com.englishportal.core.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository <Card, Long> {

    Card getById(Long id);

}

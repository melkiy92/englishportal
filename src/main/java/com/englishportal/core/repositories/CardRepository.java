package com.englishportal.core.repositories;

import com.englishportal.core.model.Card;
import com.englishportal.core.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    Card getById(Long id);

    List<Card> findAll();

    @Query(value = "SELECT id FROM englishportal.cards ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Long getRandomCardId();

}

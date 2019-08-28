package com.englishportal.core.services.servicesInterfaces;

import com.englishportal.core.model.Card;

import java.util.List;

public interface CardService {
    Card getCard(Long id);

    List<Card> getCards();

    Long getRandomCardId();

    Card getRandomCard();

    Card addCard(Card card);

    Card updateCard(Long id, Card card);

    void deleteCard(Long id);

    void deleteCards();


}

package com.englishportal.core.services;


import com.englishportal.core.model.Card;
import com.englishportal.core.model.EnWord;

public interface CardService {
    Card getCard(Long id);
    Card addCard(Card card);
}

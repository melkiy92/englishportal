package com.englishportal.core.services;

import com.englishportal.core.model.Card;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.repositories.CardRepository;
import com.englishportal.core.repositories.EnWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card getCard(Long id) {
        return cardRepository.getById(id);
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }
}

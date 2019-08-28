package com.englishportal.core.services.servicesImpl;

import com.englishportal.core.model.Card;
import com.englishportal.core.repositories.CardRepository;
import com.englishportal.core.services.servicesInterfaces.CardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    @NonNull
    private final CardRepository cardRepository;

    @Override
    public Card getCard(Long id) {
        return cardRepository.getById(id);
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getRandomCard() {
        return cardRepository.getById(cardRepository.getRandomCardId());
    }

    @Override
    public Long getRandomCardId() {
        return cardRepository.getRandomCardId();
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card updateCard(Long id, Card card) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (!cardOptional.isPresent()) {
            return null;
        }
        card.setId(id);
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    public void deleteCards() {
        cardRepository.deleteAll();
    }


}

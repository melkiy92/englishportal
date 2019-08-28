package com.englishportal.core.services.servicesInterfaces;


import com.englishportal.core.dto.GameDTO;
import com.englishportal.core.model.Card;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.Language;
import com.englishportal.core.model.WinState;
import com.englishportal.core.repositories.CardRepository;
import lombok.NonNull;

public interface GameService {
    GameDTO startGame(Long userId, Language language);

    WinState verifyAnswer(Long userId, Long cardId, Language language, String answer);
}

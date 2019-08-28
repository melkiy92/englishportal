package com.englishportal.core.services.servicesImpl;

import com.englishportal.core.dto.CardDTO;
import com.englishportal.core.dto.GameDTO;
import com.englishportal.core.model.*;
import com.englishportal.core.repositories.CardRepository;
import com.englishportal.core.services.servicesInterfaces.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final CardService cardService;
    private final EnWordService enWordService;
    private final ImageService imageService;
    private final UserService userService;

    @Override
    public GameDTO startGame(Long userId, Language language) {
        GameDTO gameDTO = new GameDTO();
        gameDTO.setUserId(userId);
        gameDTO.setCardId(cardService.getRandomCardId());
        Long cardId = gameDTO.getCardId();
        Card card = cardService.getCard(cardId);
        switch (language) {
            case en:
                gameDTO.setWord(card.getEnWord().getMeaning());
                break;
            case ru:
                gameDTO.setWord(card.getRuWord().getMeaning());
                break;
            default:
                throw new IllegalArgumentException("Invalid language.");
        }
        return gameDTO;
    }

    @Override
    public WinState verifyAnswer(Long userId, Long cardId, Language language, String answer) {
        Card card = cardService.getCard(cardId);
        String translation = "";
        switch (language) {
            case en:
                translation = card.getRuWord().getMeaning();
                break;
            case ru:
                translation = card.getEnWord().getMeaning();
                break;
            default:
                throw new IllegalArgumentException("Invalid language.");
        }
        return answer.equalsIgnoreCase(translation) ? WinState.WIN : WinState.LOOSE;
    }

}

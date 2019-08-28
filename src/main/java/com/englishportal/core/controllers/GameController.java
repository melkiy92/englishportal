package com.englishportal.core.controllers;

import com.englishportal.core.dto.EnWordDTO;
import com.englishportal.core.dto.GameDTO;
import com.englishportal.core.mappers.EnWordMapper;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.model.Language;
import com.englishportal.core.services.servicesInterfaces.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;


@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(value = "/users/{userId}/game", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GameDTO> giveCard(@PathVariable Long userId, @RequestParam Language lang) {
        GameDTO gameDTO = gameService.startGame(userId, lang);
        return new ResponseEntity<>(gameDTO, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/cards/{cardId}")
    public ResponseEntity getAnswer(@PathVariable Long userId, @PathVariable Long cardId, @RequestParam Language lang, @RequestParam String answer) {
        return new ResponseEntity<>(gameService.verifyAnswer(userId, cardId, lang, answer), HttpStatus.OK);
    }


}

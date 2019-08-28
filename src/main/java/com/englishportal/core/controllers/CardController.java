package com.englishportal.core.controllers;

import com.englishportal.core.dto.CardDTO;
import com.englishportal.core.mappers.CardMapper;
import com.englishportal.core.model.Card;
import com.englishportal.core.services.servicesInterfaces.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping("/cards/{id}")
    public ResponseEntity getCardById(@PathVariable Long id) throws IOException {
        Card card = cardService.getCard(id);
        CardDTO cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @GetMapping("/cards")
    public ResponseEntity getCards() throws IOException {
        List<Card> cards = cardService.getCards();
        CardDTO cardDTO;
        List<CardDTO> cardsDTO = new ArrayList<>();
        for (Card card : cards) {
            cardDTO = cardMapper.toDTO(card);
            cardsDTO.add(cardDTO);
        }
        return new ResponseEntity<>(cardsDTO, HttpStatus.OK);
    }

    @GetMapping("/cards/random")
    public ResponseEntity getRandomCard() throws IOException {
        Card card = cardService.getRandomCard();
        CardDTO cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/cards", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CardDTO> addCard(@RequestBody CardDTO cardDTO) throws IOException {
        Card card = cardMapper.toEntity(cardDTO);
        card = cardService.addCard(card);
        cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.CREATED);
    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<CardDTO> updateCard(@PathVariable Long id, @RequestBody CardDTO cardDTO) throws IOException {
        Card card = cardMapper.toEntity(cardDTO);
        card = cardService.updateCard(id, card);
        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        try {
            cardService.deleteCard(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/cards")
    public ResponseEntity<Void> deleteCards() {
        try {
            cardService.deleteCards();
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }


}

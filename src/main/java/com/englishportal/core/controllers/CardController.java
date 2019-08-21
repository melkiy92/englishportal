package com.englishportal.core.controllers;

import com.englishportal.core.dto.CardDTO;
import com.englishportal.core.dto.EnWordDTO;
import com.englishportal.core.mappers.CardMapper;
import com.englishportal.core.mappers.EnWordMapper;
import com.englishportal.core.model.Card;
import com.englishportal.core.model.EnWord;
import com.englishportal.core.services.CardService;
import com.englishportal.core.services.EnWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


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
        //return cardMapper.toDTO(card);
    }

    @PostMapping("/cards")
    public ResponseEntity<?> saveCard(@RequestBody CardDTO cardDTO) throws IOException {
        Card card = cardMapper.toEntity(cardDTO);
        card = cardService.addCard(card);
        cardDTO = cardMapper.toDTO(card);
        return new ResponseEntity<>(cardDTO, HttpStatus.CREATED);
    }

}

package com.card.app.controller;

import com.card.app.entity.Card;
import com.card.app.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getBudget(){
        List<Card> cards = cardService.getCard();

        return ResponseEntity.status(HttpStatus.OK).body(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Card>> getById(@PathVariable Long id) {
        Optional<Card> card = cardService.getCardById(id);

        return ResponseEntity.status(HttpStatus.OK).body(card);
    }

    @PostMapping
    public ResponseEntity<Card> saveBudget(@Valid @RequestBody Card card) {
        Card savedCard = cardService.saveCard(card);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> editBudget(@PathVariable Long id, @Valid @RequestBody Card card) {
        Card editedCard = cardService.editCard(id, card);

        return ResponseEntity.status(HttpStatus.OK).body(editedCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBudget(@PathVariable Long id) {
        cardService.deleteCard(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
    }

}

package com.card.app.service;

import com.card.app.entity.Card;
import com.card.app.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getCard(){
        return cardRepository.findAll();
    }

    public Card saveCard(Card budget) {

        if (!getCard().isEmpty()) {
            this.editCard(getCard().get(0).getId(), budget);
        } else {
            return cardRepository.save(budget);
        }

        return budget;
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public Card editCard(Long id, Card card) {
        Optional<Card> cardById = this.getCardById(id);

        if (cardById.isPresent()) {
            cardById.get().setCardName(card.getCardName());
            cardById.get().setCardImage(card.getCardImage());
            cardById.get().setPassword(card.getPassword());
            cardById.get().setBudget(card.getBudget());
        }

        return cardRepository.save(cardById.get());
    }

    public void deleteCard(Long id) {
        Optional<Card> cardById = this.getCardById(id);

        if (cardById.isPresent()) {
            cardRepository.deleteById(id);
        }
    }
}

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
            this.editCard(1L, budget);
        } else {
            return cardRepository.save(budget);
        }

        return budget;
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public Card editCard(Long id, Card budget) {
        Optional<Card> cardById = this.getCardById(id);

        if (cardById.isPresent()) {
            cardById.get().setCardName(budget.getCardName());
            cardById.get().setCardImage(budget.getCardImage());
            cardById.get().setPassword(budget.getPassword());
            cardById.get().setBudget(budget.getBudget());
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

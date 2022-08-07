package com.card.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String cardName;
    @NotBlank
    private String cardImage;
    @NotBlank
    private String password;
    @NotBlank
    private Double budget;

    public Card(String cardName, String password, Double budget) {
        this.cardName = cardName;
        this.password = password;
        this.budget = budget;
    }

}

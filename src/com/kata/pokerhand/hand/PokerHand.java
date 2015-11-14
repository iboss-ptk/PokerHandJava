package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

import java.util.Arrays;

public abstract class PokerHand {
    protected Card[] handCards;

    public PokerHand(Card[] cards) {
        if(!isValidCardAmount(cards)) {
            throw new IllegalArgumentException("A hand need five cards");
        }
        handCards = cards;
    }

    public Card highestValueCard() {
        return Arrays.stream(this.handCards)
            .reduce(this.handCards[0], (acc, curr) -> acc.isHigherRankThan(curr) ? acc : curr);
    }

    private boolean isValidCardAmount(Card[] cards) {
        return cards.length == 5;
    }
    abstract public boolean isWinAgainstInSameHandClass(PokerHand anotherHand);
}

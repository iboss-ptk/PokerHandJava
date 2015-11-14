package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class HighCard extends PokerHand {
    public HighCard(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand anotherHand) {
        return this.highestValueCard().isHigherRankThan(anotherHand.highestValueCard());
    }
}

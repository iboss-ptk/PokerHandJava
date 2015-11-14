package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class Pair extends PokerHand {
    public Pair(Card[] cards) {
        super(cards);
    }
    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        // TODO: find all pair
        return false;
    }
}

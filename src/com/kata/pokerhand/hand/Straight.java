package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class Straight extends PokerHand {
    public Straight(Card[] cards) {
        super(cards);
    }
    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }
}

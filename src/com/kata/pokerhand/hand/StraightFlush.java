package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class StraightFlush extends PokerHand {
    public StraightFlush(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }
}
package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class TwoPairs extends PokerHand {
    public TwoPairs(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }
}

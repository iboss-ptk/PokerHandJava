package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class Flush extends PokerHand {
    public Flush(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }

}

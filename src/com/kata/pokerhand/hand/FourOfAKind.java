package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class FourOfAKind extends PokerHand{
    public FourOfAKind(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }

}

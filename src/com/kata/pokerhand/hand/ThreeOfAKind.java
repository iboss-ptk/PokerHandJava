package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class ThreeOfAKind extends PokerHand {
    public ThreeOfAKind(Card[] cards) {
        super(cards);
    }
    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }
}

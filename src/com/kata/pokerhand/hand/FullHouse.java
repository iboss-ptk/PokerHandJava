package com.kata.pokerhand.hand;


import com.kata.pokerhand.card.Card;

public class FullHouse extends PokerHand {
    public FullHouse(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstInSameHandClass(PokerHand hand) {
        return false;
    }
}

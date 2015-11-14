package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class PokerHandFactory {
    public PokerHand getPokerHand(Card[] cards) {
        return new HighCard(cards);
    }
}

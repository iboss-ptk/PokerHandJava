package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class HighCard extends PokerHand implements LocalWinAgainstable<HighCard> {
    public HighCard(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(HighCard anotherHand) {
        return this.highestValueCard().isHigherRankThan(anotherHand.highestValueCard());
    }
}

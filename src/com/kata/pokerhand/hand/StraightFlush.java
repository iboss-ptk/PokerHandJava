package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class StraightFlush extends PokerHand implements LocalWinAgainstable<StraightFlush> {
    public StraightFlush(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(StraightFlush anotherHand) {
        HighCard thisAsHighCard = new HighCard(this.handCards);
        HighCard anotherAsHighCard = new HighCard(anotherHand.handCards);
        return thisAsHighCard.isWinAgainstLocal(anotherAsHighCard);
    }
}

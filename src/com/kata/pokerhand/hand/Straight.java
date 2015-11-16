package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class Straight extends PokerHand implements LocalWinAgainstable<Straight> {
    public Straight(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(Straight anotherHand) {
        HighCard thisAsHighCard = new HighCard(this.handCards);
        HighCard anotherAsHighCard = new HighCard(anotherHand.handCards);
        return thisAsHighCard.isWinAgainstLocal(anotherAsHighCard);
    }
}

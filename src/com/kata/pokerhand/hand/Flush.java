package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class Flush extends PokerHand implements LocalWinAgainstable<Flush> {
    public Flush(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(Flush anotherHand) {
        HighCard thisAsHighCard = new HighCard(this.handCards);
        HighCard anotherAsHighCard = new HighCard(anotherHand.handCards);
        return thisAsHighCard.isWinAgainstLocal(anotherAsHighCard);
    }
}

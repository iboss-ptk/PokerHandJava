package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class Pair extends PokerHand implements LocalWinAgainstable<Pair> {
    public Pair(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(Pair anotherHand) {
        Card thisPairCard = this.findPairCard();
        Card anotherPairCard = anotherHand.findPairCard();
        if (thisPairCard.hasSameValueAs(anotherPairCard)) {
           return this.highestValueCard().isHigherRankThan(anotherHand.highestValueCard());
        }
        return thisPairCard.isHigherRankThan(anotherPairCard);
    }

    private Card findPairCard() {
        return this.findRepresentativeCardOfAGroupOf(2);
    }
}

package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class ThreeOfAKind extends PokerHand implements LocalWinAgainstable<ThreeOfAKind> {
    public ThreeOfAKind(Card[] cards) {
        super(cards);
    }
    @Override
    public boolean isWinAgainstLocal(ThreeOfAKind anotherHand) {
        Card thisThreeCardRepresentative = this.findRepresentativeCardOfAGroupOf(3);
        Card anotherThreeCardRepresentative = anotherHand.findRepresentativeCardOfAGroupOf(3);

        if(thisThreeCardRepresentative.isDraw(anotherThreeCardRepresentative)) {
            Card thisHighestNonThreeOfAKindMember = this.highestValueCard(thisThreeCardRepresentative);
            Card anotherHighestNonThreeOfAKindMember = anotherHand.highestValueCard(thisThreeCardRepresentative);

            return thisHighestNonThreeOfAKindMember.isHigherRankThan(anotherHighestNonThreeOfAKindMember);
        }

        return thisThreeCardRepresentative.isHigherRankThan(anotherThreeCardRepresentative);
    }
}

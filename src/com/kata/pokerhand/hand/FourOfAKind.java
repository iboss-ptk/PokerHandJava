package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class FourOfAKind extends PokerHand implements LocalWinAgainstable<FourOfAKind> {
    public FourOfAKind(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(FourOfAKind anotherHand) {
        Card thisFourCardRepresentative = this.findRepresentativeCardOfAGroupOf(4);
        Card anotherFourCardRepresentative = anotherHand.findRepresentativeCardOfAGroupOf(4);

        if(thisFourCardRepresentative.isDraw(anotherFourCardRepresentative)) {
            Card thisHighestNonThreeOfAKindMember = this.highestValueCard(thisFourCardRepresentative);
            Card anotherHighestNonThreeOfAKindMember = anotherHand.highestValueCard(thisFourCardRepresentative);

            return thisHighestNonThreeOfAKindMember.isHigherRankThan(anotherHighestNonThreeOfAKindMember);
        }

        return thisFourCardRepresentative.isHigherRankThan(anotherFourCardRepresentative);
    }

}

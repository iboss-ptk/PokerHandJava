package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

public class TwoPairs extends PokerHand implements LocalWinAgainstable<TwoPairs> {
    private enum PairValue { HIGHER, LOWER, NON_PAIR }

    public TwoPairs(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(TwoPairs anotherHand) {
        Card thisHigherPairRepresentative = this.findAPair(PairValue.HIGHER);
        Card anotherHigherPairRepresentative = anotherHand.findAPair(PairValue.HIGHER);

        // higher pair has the same value, consider lower pair
        if(thisHigherPairRepresentative.hasSameValueAs(anotherHigherPairRepresentative)) {
            Card thisLowerPairRepresentative = this.findAPair(PairValue.LOWER);
            Card anotherLowerPairRepresentative = anotherHand.findAPair(PairValue.LOWER);

            // lower pair has the same value, consider non-pair
            if(thisLowerPairRepresentative.hasSameValueAs(anotherLowerPairRepresentative)) {
                return this.findAPair(PairValue.NON_PAIR).isHigherRankThan(anotherHand.findAPair(PairValue.NON_PAIR));
            }

            return thisLowerPairRepresentative.isHigherRankThan(anotherLowerPairRepresentative);
        }


        return thisHigherPairRepresentative.isHigherRankThan(anotherHigherPairRepresentative);
    }


    private Card findAPair(PairValue expectedPairValue) {
        Card pairRepresentativeCard = findRepresentativeCardOfAGroupOf(2);
        Card anotherPairRepresentativeCard = findRepresentativeCardOfAGroupOf(2, pairRepresentativeCard);

        if(expectedPairValue == PairValue.HIGHER) {
            return pairRepresentativeCard.isHigherRankThan(anotherPairRepresentativeCard) ?
                    pairRepresentativeCard : anotherPairRepresentativeCard;
        }

        if(expectedPairValue == PairValue.LOWER) {
            return pairRepresentativeCard.isHigherRankThan(anotherPairRepresentativeCard) ?
                    anotherPairRepresentativeCard : pairRepresentativeCard;
        }

        if(expectedPairValue == PairValue.NON_PAIR) {
            for(Card card : this.handCards) {
                if(!card.hasSameValueAs(pairRepresentativeCard) && !card.hasSameValueAs(anotherPairRepresentativeCard)) {
                    return card;
                }
            }
        }

        throw new NullPointerException();
    }
}

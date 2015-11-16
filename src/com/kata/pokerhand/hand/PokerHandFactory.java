package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PokerHandFactory {
    public PokerHand getPokerHand(Card[] cards) {
        if( isStraightFlush(cards) )
            return new StraightFlush(cards);

        if( isFourOfAKind(cards) )
            return new FourOfAKind(cards);

        if( isFullHouse(cards) )
            return new FullHouse(cards);

        if( isFlush(cards) )
            return new Flush(cards);

        if( isStraight(cards) )
            return new Straight(cards);

        if( isThreeOfAKind(cards) )
            return new ThreeOfAKind(cards);

        if( isTwoPairs(cards) )
            return new TwoPairs(cards);

        if( isPair(cards) )
            return new Pair(cards);

        return new HighCard(cards);
    }

    protected boolean isStraightFlush(Card[] cards) {
        return isStraight(cards) && isFlush(cards);
    }

    protected boolean isFlush(Card[] cards) {
        boolean isNoOddSuit = Arrays.stream(cards)
                .filter( card -> !card.hasSameSuitAs(cards[0]))
                .toArray()
                .length == 0;

        return isNoOddSuit;
    }

    protected boolean isStraight(Card[] cards) {
        int[] sortedCardValueArray = Arrays.stream(cards)
                .sorted((c1, c2) -> Integer.compare(c1.getIntValue(), c2.getIntValue()))
                .mapToInt(c -> c.getIntValue())
                .toArray();

        for (int i = 0; i < sortedCardValueArray.length - 1 ; i++) {
            int localDiff = sortedCardValueArray[i + 1] - sortedCardValueArray[i];

            if(localDiff != 1) {
                return false;
            }
        }

        return true;
    }

    protected boolean isFullHouse(Card[] cards) {
        return numberOfSubgroup(cards) == 2 && maxCardValueDuplication(cards) == 3;
    }

    protected boolean isFourOfAKind(Card[] cards) {
        return numberOfSubgroup(cards) == 2 && maxCardValueDuplication(cards) == 4;
    }

    protected boolean isThreeOfAKind(Card[] cards) {
        return numberOfSubgroup(cards) == 3 && maxCardValueDuplication(cards) == 3;
    }

    protected boolean isTwoPairs(Card[] cards) {
        return numberOfSubgroup(cards) == 3 && maxCardValueDuplication(cards) == 2;
    }

    protected boolean isPair(Card[] cards) {
        return numberOfSubgroup(cards) == 4 && maxCardValueDuplication(cards) == 2;
    }

    private int numberOfSubgroup(Card[] cards) {
        Set<Integer> cardValueSet = new HashSet();

        for (Card card : cards) {
            cardValueSet.add(card.getIntValue());
        }
        return cardValueSet.size();
    }

    private int maxCardValueDuplication(Card[] cards) {
        int max = 0, count = 0;
        for (Card card : cards) {
            for (Card innerCard : cards) {
                if(card.isDraw(innerCard)) {
                    count = count + 1;
                    max = count > max ? count : max;
                }
            }
            count = 0;
        }

        return max;
    }
}

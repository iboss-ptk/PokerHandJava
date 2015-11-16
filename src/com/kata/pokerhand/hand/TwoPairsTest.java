package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPairsTest {
    Card[] cardsOne = {
            new Card('3', 'C'),
            new Card('3', 'S'),
            new Card('6', 'S'),
            new Card('2', 'H'),
            new Card('2', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('7', 'H'),
            new Card('5', 'S'),
            new Card('2', 'H'),
            new Card('2', 'D')
    };

    Card[] cardsThree = {
            new Card('7', 'C'),
            new Card('7', 'H'),
            new Card('Q', 'S'),
            new Card('2', 'H'),
            new Card('2', 'D')
    };

    Card[] cardsFour = {
            new Card('7', 'C'),
            new Card('7', 'H'),
            new Card('Q', 'S'),
            new Card('3', 'H'),
            new Card('3', 'D')
    };

    TwoPairs twoPairsOne = new TwoPairs(cardsOne);
    TwoPairs twoPairsTwo = new TwoPairs(cardsTwo);
    TwoPairs TwoPairsThree = new TwoPairs(cardsThree);
    TwoPairs TwoPairsFour = new TwoPairs(cardsFour);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestPairValue() {
        assertEquals(twoPairsOne.isWinAgainstLocal(twoPairsTwo), false);
        assertEquals(twoPairsTwo.isWinAgainstLocal(twoPairsOne), true);
    }

    @Test
    public void isWinAgainstInSameHandClassShouldCompareLowerPairValueWhenHigherPairValueIsEqual() {
        assertEquals(TwoPairsFour.isWinAgainstLocal(TwoPairsThree), true);
        assertEquals(TwoPairsThree.isWinAgainstLocal(TwoPairsFour), false);
    }

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestCardWhenAllPairValueIsEqual() {
        assertEquals(TwoPairsThree.isWinAgainstLocal(twoPairsTwo), true);
        assertEquals(twoPairsTwo.isWinAgainstLocal(TwoPairsThree), false);
    }
}
package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairTest {
    Card[] cardsOne = {
            new Card('3', 'C'),
            new Card('3', 'S'),
            new Card('6', 'S'),
            new Card('Q', 'H'),
            new Card('8', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('3', 'H'),
            new Card('5', 'S'),
            new Card('2', 'H'),
            new Card('2', 'D')
    };

    Card[] cardsThree = {
            new Card('Q', 'C'),
            new Card('7', 'H'),
            new Card('5', 'S'),
            new Card('2', 'H'),
            new Card('2', 'D')
    };

    Pair pairOne = new Pair(cardsOne);
    Pair pairTwo = new Pair(cardsTwo);
    Pair pairThree = new Pair(cardsThree);

    @Test
    public void isWinAgainstInSameHandClassShouldComparePairValue() {
        assertEquals(pairOne.isWinAgainstLocal(pairTwo), true);
        assertEquals(pairTwo.isWinAgainstLocal(pairOne), false);
    }

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestCardWhenPairValueIsEqual() {
        assertEquals(pairThree.isWinAgainstLocal(pairTwo), true);
        assertEquals(pairTwo.isWinAgainstLocal(pairThree), false);
    }
}
package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class FullHouseTest {
    Card[] cardsOne = {
            new Card('3', 'C'),
            new Card('3', 'S'),
            new Card('3', 'H'),
            new Card('Q', 'H'),
            new Card('Q', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('7', 'H'),
            new Card('5', 'S'),
            new Card('5', 'H'),
            new Card('5', 'D')
    };

    Card[] cardsThree = {
            new Card('Q', 'C'),
            new Card('Q', 'H'),
            new Card('5', 'S'),
            new Card('5', 'H'),
            new Card('5', 'D')
    };

    FullHouse fullHouseOne = new FullHouse(cardsOne);
    FullHouse fullHouseTwo = new FullHouse(cardsTwo);
    FullHouse fullHouseThree = new FullHouse(cardsThree);

    @Test
    public void isWinAgainstInSameHandClassShouldComparefullHouseValue() {
        assertEquals(fullHouseTwo.isWinAgainstLocal(fullHouseOne), true);
        assertEquals(fullHouseOne.isWinAgainstLocal(fullHouseTwo), false);
    }

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestNonMemberOfGroupOfThreeIfGroupOfThreeHasTheSameValue() {
        assertEquals(fullHouseThree.isWinAgainstLocal(fullHouseTwo), true);
        assertEquals(fullHouseTwo.isWinAgainstLocal(fullHouseThree), false);
    }
}
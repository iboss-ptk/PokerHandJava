package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class StraightTest {
    Card[] cardsOne = {
            new Card('4', 'C'),
            new Card('5', 'C'),
            new Card('6', 'S'),
            new Card('7', 'H'),
            new Card('8', 'D')
    };

    Card[] cardsTwo = {
            new Card('9', 'C'),
            new Card('T', 'H'),
            new Card('J', 'S'),
            new Card('K', 'H'),
            new Card('Q', 'D')
    };

    Straight straightOne = new Straight(cardsOne);
    Straight straightTwo = new Straight(cardsTwo);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestValueCard() {
        assertEquals(straightOne.isWinAgainstLocal(straightTwo), false);
        assertEquals(straightTwo.isWinAgainstLocal(straightOne), true);
    }
}
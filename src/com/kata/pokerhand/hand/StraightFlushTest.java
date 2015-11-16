package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class StraightFlushTest {
    Card[] cardsOne = {
            new Card('4', 'C'),
            new Card('5', 'C'),
            new Card('6', 'C'),
            new Card('7', 'C'),
            new Card('8', 'C')
    };

    Card[] cardsTwo = {
            new Card('9', 'H'),
            new Card('T', 'H'),
            new Card('J', 'H'),
            new Card('K', 'H'),
            new Card('Q', 'H')
    };

    StraightFlush straightFlushOne = new StraightFlush(cardsOne);
    StraightFlush straightFlushTwo = new StraightFlush(cardsTwo);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestValueCard() {
        assertEquals(straightFlushOne.isWinAgainstLocal(straightFlushTwo), false);
        assertEquals(straightFlushTwo.isWinAgainstLocal(straightFlushOne), true);
    }
}
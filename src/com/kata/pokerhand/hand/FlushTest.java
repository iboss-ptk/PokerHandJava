package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlushTest {
    Card[] cardsOne = {
            new Card('2', 'C'),
            new Card('4', 'C'),
            new Card('6', 'C'),
            new Card('Q', 'C'),
            new Card('8', 'C')
    };

    Card[] cardsTwo = {
            new Card('7', 'H'),
            new Card('4', 'H'),
            new Card('5', 'H'),
            new Card('K', 'H'),
            new Card('2', 'H')
    };

    HighCard highCardOne = new HighCard(cardsOne);
    HighCard highCardTwo = new HighCard(cardsTwo);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestValueCard() {
        assertEquals(highCardOne.isWinAgainstLocal(highCardTwo), false);
        assertEquals(highCardTwo.isWinAgainstLocal(highCardOne), true);
    }
}
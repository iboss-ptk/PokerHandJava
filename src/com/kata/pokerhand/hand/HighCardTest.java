package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class HighCardTest {
    Card[] cardsOne = {
            new Card('2', 'C'),
            new Card('4', 'C'),
            new Card('6', 'S'),
            new Card('Q', 'H'),
            new Card('8', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('4', 'H'),
            new Card('5', 'S'),
            new Card('K', 'H'),
            new Card('2', 'D')
    };

    HighCard highCardOne = new HighCard(cardsOne);
    HighCard highCardTwo = new HighCard(cardsTwo);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestValueCard() {
        assertEquals(highCardOne.isWinAgainstInSameHandClass(highCardTwo), false);
        assertEquals(highCardTwo.isWinAgainstInSameHandClass(highCardOne), true);
    }
}
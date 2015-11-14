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
            new Card('7', 'H'),
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

    HighCard highCardOne = new HighCard(cardsOne);
    HighCard highCardTwo = new HighCard(cardsTwo);
    HighCard highCardThree = new HighCard(cardsThree);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestPairValueCard() {
        assertEquals(highCardOne.isWinAgainstInSameHandClass(highCardTwo), false);
        assertEquals(highCardTwo.isWinAgainstInSameHandClass(highCardOne), true);

        assertEquals(highCardThree.isWinAgainstInSameHandClass(highCardTwo), false);
        assertEquals(highCardTwo.isWinAgainstInSameHandClass(highCardThree), true);
    }
}
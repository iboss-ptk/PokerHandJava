package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandFactoryTest {
    PokerHandFactory pokerHandFactory = new PokerHandFactory();

    @Test
    public void getPokerHandShouldBeAbleToReturnPokerHand() {
        Card[] cards = {
          new Card('2', 'C'),
          new Card('4', 'C'),
          new Card('6', 'S'),
          new Card('Q', 'H'),
          new Card('2', 'D')
        };
        pokerHandFactory.getPokerHand(cards);

        assertEquals(pokerHandFactory.getPokerHand(cards).getClass(), Pair.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pokerHandShouldFailToReturnPokerHandWhenCardArrayLengthIsNotFive() throws Exception {
        Card[] cards = {
                new Card('2', 'C'),
                new Card('4', 'C'),
                new Card('6', 'S'),
                new Card('Q', 'H')
        };
        pokerHandFactory.getPokerHand(cards);
    }

    @Test
    public void isStraightFlushShouldCheckIfSetOfCardIsStraightFLush() {
        Card[] cardsOne = {
                new Card('4', 'C'),
                new Card('5', 'C'),
                new Card('6', 'C'),
                new Card('7', 'H'),
                new Card('8', 'H')
        };

        Card[] cardsTwo = {
                new Card('4', 'C'),
                new Card('5', 'C'),
                new Card('6', 'C'),
                new Card('3', 'C'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('4', 'C'),
                new Card('5', 'C'),
                new Card('6', 'C'),
                new Card('7', 'C'),
                new Card('8', 'C')
        };

        assertFalse(pokerHandFactory.isStraightFlush(cardsOne));
        assertFalse(pokerHandFactory.isStraightFlush(cardsTwo));
        assertTrue(pokerHandFactory.isStraightFlush(cardsThree));
    }

    @Test
    public void isFlushShouldCheckIfSetOfCardIsFLush() {
        Card[] cardsOne = {
                new Card('4', 'C'),
                new Card('5', 'C'),
                new Card('6', 'C'),
                new Card('7', 'H'),
                new Card('8', 'H')
        };

        Card[] cardsTwo = {
                new Card('4', 'C'),
                new Card('5', 'C'),
                new Card('6', 'C'),
                new Card('3', 'C'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('4', 'H'),
                new Card('5', 'H'),
                new Card('6', 'H'),
                new Card('7', 'H'),
                new Card('8', 'H')
        };

        assertFalse(pokerHandFactory.isFlush(cardsOne));
        assertTrue(pokerHandFactory.isFlush(cardsTwo));
        assertTrue(pokerHandFactory.isFlush(cardsThree));
    }

    @Test
    public void isStraightShouldCheckIfSetOfCardIsStraight() {
        Card[] cardsOne = {
                new Card('K', 'C'),
                new Card('Q', 'C'),
                new Card('J', 'C'),
                new Card('T', 'H'),
                new Card('9', 'H')
        };

        Card[] cardsTwo = {
                new Card('4', 'C'),
                new Card('5', 'C'),
                new Card('6', 'C'),
                new Card('3', 'C'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('4', 'H'),
                new Card('5', 'H'),
                new Card('6', 'H'),
                new Card('7', 'H'),
                new Card('8', 'H')
        };

        assertTrue(pokerHandFactory.isStraight(cardsOne));
        assertFalse(pokerHandFactory.isStraight(cardsTwo));
        assertTrue(pokerHandFactory.isStraight(cardsThree));
    }

    @Test
    public void isFullHouseShouldCheckIfSetOfCardIsFullHouse() {
        Card[] cardsOne = {
                new Card('K', 'C'),
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('9', 'H'),
                new Card('9', 'S')
        };

        Card[] cardsTwo = {
                new Card('2', 'H'),
                new Card('2', 'C'),
                new Card('6', 'C'),
                new Card('3', 'S'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('7', 'S'),
                new Card('8', 'H')
        };

        Card[] cardsFour = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('K', 'D'),
                new Card('8', 'H')
        };

        assertTrue(pokerHandFactory.isFullHouse(cardsOne));
        assertFalse(pokerHandFactory.isFullHouse(cardsTwo));
        assertFalse(pokerHandFactory.isFullHouse(cardsThree));
        assertFalse(pokerHandFactory.isFullHouse(cardsFour));
    }

    @Test
    public void isFourOfAKindShouldCheckIfSetOfCardIsFourOfAKind() {
        Card[] cardsOne = {
                new Card('K', 'C'),
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('9', 'H'),
                new Card('9', 'S')
        };

        Card[] cardsTwo = {
                new Card('2', 'H'),
                new Card('2', 'C'),
                new Card('6', 'C'),
                new Card('3', 'S'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('7', 'S'),
                new Card('8', 'H')
        };

        Card[] cardsFour = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('K', 'D'),
                new Card('8', 'H')
        };

        assertFalse(pokerHandFactory.isFourOfAKind(cardsOne));
        assertFalse(pokerHandFactory.isFourOfAKind(cardsTwo));
        assertFalse(pokerHandFactory.isFourOfAKind(cardsThree));
        assertTrue(pokerHandFactory.isFourOfAKind(cardsFour));
    }

    @Test
    public void isThreeOfAKindShouldCheckIfSetOfCardIsThreeOfAKind() {
        Card[] cardsOne = {
                new Card('K', 'C'),
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('9', 'H'),
                new Card('9', 'S')
        };

        Card[] cardsTwo = {
                new Card('2', 'H'),
                new Card('2', 'C'),
                new Card('6', 'C'),
                new Card('3', 'S'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('7', 'S'),
                new Card('8', 'H')
        };

        Card[] cardsFour = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('K', 'D'),
                new Card('8', 'H')
        };

        assertFalse(pokerHandFactory.isThreeOfAKind(cardsOne));
        assertFalse(pokerHandFactory.isThreeOfAKind(cardsTwo));
        assertTrue(pokerHandFactory.isThreeOfAKind(cardsThree));
        assertFalse(pokerHandFactory.isThreeOfAKind(cardsFour));
    }

    @Test
    public void isTwoPairShouldCheckIfSetOfCardIsTwoPair() {
        Card[] cardsOne = {
                new Card('K', 'C'),
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('9', 'H'),
                new Card('9', 'S')
        };

        Card[] cardsTwo = {
                new Card('2', 'H'),
                new Card('2', 'C'),
                new Card('6', 'C'),
                new Card('3', 'S'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('7', 'C'),
                new Card('7', 'S'),
                new Card('8', 'H')
        };

        Card[] cardsFour = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('K', 'D'),
                new Card('8', 'H')
        };

        assertFalse(pokerHandFactory.isTwoPairs(cardsOne));
        assertFalse(pokerHandFactory.isTwoPairs(cardsTwo));
        assertTrue(pokerHandFactory.isTwoPairs(cardsThree));
        assertFalse(pokerHandFactory.isTwoPairs(cardsFour));
    }

    @Test
    public void isPairShouldCheckIfSetOfCardIsPair() {
        Card[] cardsOne = {
                new Card('K', 'C'),
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('9', 'H'),
                new Card('9', 'S')
        };

        Card[] cardsTwo = {
                new Card('2', 'H'),
                new Card('2', 'C'),
                new Card('6', 'C'),
                new Card('6', 'S'),
                new Card('8', 'C')
        };

        Card[] cardsThree = {
                new Card('K', 'H'),
                new Card('Q', 'S'),
                new Card('7', 'C'),
                new Card('7', 'S'),
                new Card('8', 'H')
        };

        Card[] cardsFour = {
                new Card('K', 'H'),
                new Card('K', 'S'),
                new Card('K', 'C'),
                new Card('K', 'D'),
                new Card('8', 'H')
        };

        assertFalse(pokerHandFactory.isPair(cardsOne));
        assertFalse(pokerHandFactory.isPair(cardsTwo));
        assertTrue(pokerHandFactory.isPair(cardsThree));
        assertFalse(pokerHandFactory.isPair(cardsFour));
    }
}
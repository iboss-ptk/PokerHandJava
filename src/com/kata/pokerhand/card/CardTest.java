package com.kata.pokerhand.card;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void cardShouldBeAbleToBeCreated() {
        Card card = new Card('2', 'C');
    }

    @Test(expected = IllegalArgumentException.class)
    public void cardShouldFailToBeCreatedWhenSuitIsNotAcceptable() throws Exception {
        Card card = new Card('1', 'X');
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void cardShouldFailToBeCreatedWhenValueIsNotAcceptable() throws Exception {
        Card card = new Card('e', 'C');
        fail();
    }

    @Test
    public void isHigherRankThanLowerValueCardShouldReturnTrue() {
        Card fiveSpade = new Card('5', 'S');
        Card queenSpade = new Card('Q', 'S');

        assertEquals(queenSpade.isHigherRankThan(fiveSpade), true);
    }

    @Test
    public void isHigherRankThanHigherValueCardShouldReturnFalse() {
        Card fiveSpade = new Card('5', 'S');
        Card queenSpade = new Card('Q', 'S');

        assertEquals(fiveSpade.isHigherRankThan(queenSpade), false);
    }

    @Test
    public void isDrawShouldIgnoreSuit() {
        Card queenHeart = new Card('Q', 'H');
        Card queenSpade = new Card('Q', 'S');

        assertEquals(queenHeart.isDraw(queenSpade), true);
    }

    @Test
    public void hasSameSuitAsShouldCheckSamenessOfCardSuit() {
        Card queenHeart = new Card('Q', 'H');
        Card tenHeart = new Card('T', 'H');
        Card threeSpade = new Card('3', 'S');

        assertEquals(queenHeart.hasSameSuitAs(tenHeart), true);
        assertEquals(queenHeart.hasSameSuitAs(threeSpade), false);
    }

    @Test
    public void hasSameValueAsShouldCheckSamenessOfCardValue() {
        Card queenHeart = new Card('Q', 'H');
        Card tenHeart = new Card('T', 'H');
        Card tenSpade = new Card('T', 'S');

        assertEquals(tenSpade.hasSameValueAs(tenHeart), true);
        assertEquals(tenSpade.hasSameValueAs(queenHeart), false);
    }

    @Test
    public void valueDifferenceFromShouldReturnVectorOfDifferenceBetweenTwoCard() {
        Card queenHeart = new Card('Q', 'H');
        Card tenHeart = new Card('T', 'H');
        Card tenSpade = new Card('T', 'S');

        assertEquals(tenSpade.valueDifferenceFrom(tenHeart), 0);
        assertEquals(tenSpade.valueDifferenceFrom(queenHeart), -2);
    }
}
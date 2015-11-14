package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {
    class PockerHandMock extends PokerHand {
        public PockerHandMock(Card[] cards) {
            super(cards);
        }
        @Override
        public boolean isWinAgainstInSameHandClass(PokerHand anotherHand) {
            return false;
        }
    }

    Card[] cards = {
            new Card('2', 'C'),
            new Card('4', 'C'),
            new Card('6', 'S'),
            new Card('Q', 'H'),
            new Card('2', 'D')
    };

    PockerHandMock pockerHandMock = new PockerHandMock(cards);

    @Test
    public void highestValueCardShouldReturnACardWithHighestValue() {
        Card realHighestValueCard = pockerHandMock.highestValueCard();
        Card expectedHighestValueCard = new Card('Q', 'H');

        assertEquals(realHighestValueCard.isDraw(expectedHighestValueCard), true);
    }
}
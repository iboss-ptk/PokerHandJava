package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerHandTest {
    class PokerHandMock extends PokerHand implements LocalWinAgainstable<PokerHandMock> {
        public PokerHandMock(Card[] cards) {
            super(cards);
        }
        @Override
        public boolean isWinAgainstLocal(PokerHandMock anotherHand) {
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

    Card[] cardsTwo = {
            new Card('2', 'C'),
            new Card('6', 'C'),
            new Card('6', 'S'),
            new Card('Q', 'H'),
            new Card('2', 'D')
    };

    PokerHandMock pokerHandMock = new PokerHandMock(cards);
    PokerHandMock pokerHandMockTwo = new PokerHandMock(cardsTwo);

    @Test
    public void highestValueCardShouldReturnACardWithHighestValue() {
        Card realHighestValueCard = pokerHandMock.highestValueCard();
        Card expectedHighestValueCard = new Card('Q', 'H');

        assertEquals(realHighestValueCard.isDraw(expectedHighestValueCard), true);
    }

    @Test
    public void highestValueCardShouldReturnACardWithHighestValueWithExclusion() {
        Card excludedValueCard = new Card('Q', 'H');
        Card expectedHighestValueCard = new Card('6', 'S');
        Card realHighestValueCard = pokerHandMock.highestValueCard(excludedValueCard);

        assertEquals(realHighestValueCard.isDraw(expectedHighestValueCard), true);

        excludedValueCard = new Card('6', 'S');
        expectedHighestValueCard = new Card('Q', 'H');
        realHighestValueCard = pokerHandMock.highestValueCard(excludedValueCard);
    }

    @Test
    public void findRepresentativeCardOfAGroupOfShouldReturnARepresentativeCardForAGroupOfN() {
        Card twoHeart = new Card('2', 'H');
        Card representativeCard = pokerHandMock.findRepresentativeCardOfAGroupOf(2);

        assertEquals(representativeCard.hasSameValueAs(twoHeart), true);
    }

    @Test
    public void findRepresentativeCardOfAGroupOfShouldReturnARepresentativeCardForAGroupOfNWithExclusion() {
        Card twoHeart = new Card('2', 'H');
        Card representativeCard = pokerHandMockTwo.findRepresentativeCardOfAGroupOf(2, twoHeart);

        assertEquals(representativeCard.hasSameValueAs(new Card('6', 'C')), true);
    }
}
package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class FourOfAKindTest {
    Card[] cardsOne = {
            new Card('3', 'C'),
            new Card('3', 'S'),
            new Card('3', 'H'),
            new Card('Q', 'H'),
            new Card('3', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('5', 'H'),
            new Card('5', 'S'),
            new Card('5', 'H'),
            new Card('5', 'D')
    };

    Card[] cardsThree = {
            new Card('Q', 'C'),
            new Card('5', 'H'),
            new Card('5', 'S'),
            new Card('5', 'H'),
            new Card('5', 'D')
    };

    FourOfAKind fourOfAKindOne = new FourOfAKind(cardsOne);
    FourOfAKind fourOfAKindTwo = new FourOfAKind(cardsTwo);
    FourOfAKind fourOfAKindThree = new FourOfAKind(cardsThree);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareThreeOfAKindValue() {
        assertEquals(fourOfAKindTwo.isWinAgainstLocal(fourOfAKindOne), true);
        assertEquals(fourOfAKindOne.isWinAgainstLocal(fourOfAKindTwo), false);
    }

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestNonMemberOfGroupOfThreeIfGroupOfThreeHasTheSameValue() {
        assertEquals(fourOfAKindThree.isWinAgainstLocal(fourOfAKindTwo), true);
        assertEquals(fourOfAKindTwo.isWinAgainstLocal(fourOfAKindThree), false);
    }
}
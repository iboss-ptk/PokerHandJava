package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeOfAKindTest {
    Card[] cardsOne = {
            new Card('3', 'C'),
            new Card('3', 'S'),
            new Card('3', 'H'),
            new Card('Q', 'H'),
            new Card('8', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('3', 'H'),
            new Card('5', 'S'),
            new Card('5', 'H'),
            new Card('5', 'D')
    };

    Card[] cardsThree = {
            new Card('Q', 'C'),
            new Card('7', 'H'),
            new Card('5', 'S'),
            new Card('5', 'H'),
            new Card('5', 'D')
    };

    ThreeOfAKind threeOfAKindOne = new ThreeOfAKind(cardsOne);
    ThreeOfAKind threeOfAKindTwo = new ThreeOfAKind(cardsTwo);
    ThreeOfAKind threeOfAKindThree = new ThreeOfAKind(cardsThree);

    @Test
    public void isWinAgainstInSameHandClassShouldCompareThreeOfAKindValue() {
        assertEquals(threeOfAKindTwo.isWinAgainstLocal(threeOfAKindOne), true);
        assertEquals(threeOfAKindOne.isWinAgainstLocal(threeOfAKindTwo), false);
    }

    @Test
    public void isWinAgainstInSameHandClassShouldCompareHighestNonMemberOfGroupOfThreeIfGroupOfThreeHasTheSameValue() {
        assertEquals(threeOfAKindThree.isWinAgainstLocal(threeOfAKindTwo), true);
        assertEquals(threeOfAKindTwo.isWinAgainstLocal(threeOfAKindThree), false);
    }
}
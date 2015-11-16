package com.kata.pokerhand;

import com.kata.pokerhand.card.Card;
import com.kata.pokerhand.hand.PokerHand;
import com.kata.pokerhand.hand.PokerHandFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommitteeTest {

    Card[] cardsOne = {
            new Card('7', 'C'),
            new Card('4', 'H'),
            new Card('5', 'S'),
            new Card('K', 'H'),
            new Card('2', 'D')
    };

    Card[] cardsTwo = {
            new Card('7', 'C'),
            new Card('4', 'H'),
            new Card('K', 'S'),
            new Card('K', 'H'),
            new Card('K', 'D')
    };

    Card[] cardsThree = {
            new Card('6', 'C'),
            new Card('4', 'H'),
            new Card('Q', 'S'),
            new Card('Q', 'H'),
            new Card('Q', 'D')
    };

    Card[] cardsFour = {
            new Card('2', 'C'),
            new Card('4', 'H'),
            new Card('5', 'S'),
            new Card('K', 'H'),
            new Card('7', 'D')
    };

    PokerHandFactory pokerHandFactory = new PokerHandFactory();
    PokerHand pokerHand1 = pokerHandFactory.getPokerHand(cardsOne);
    PokerHand pokerHand2 = pokerHandFactory.getPokerHand(cardsTwo);
    PokerHand pokerHand3 = pokerHandFactory.getPokerHand(cardsThree);
    PokerHand pokerHand4 = pokerHandFactory.getPokerHand(cardsFour);


    @Test
    public void judgeShouldReturnTrueIfPokerHand1IsWinElseFalse() {
        Committee committee = new Committee();
        // different hand type
        assertEquals(committee.judge(pokerHand1, pokerHand2), Committee.GameResult.WHITE_WINS);
        assertEquals(committee.judge(pokerHand2, pokerHand1), Committee.GameResult.BLACK_WINS);

        // same hand type
        assertEquals(committee.judge(pokerHand2, pokerHand3), Committee.GameResult.BLACK_WINS);
        assertEquals(committee.judge(pokerHand3, pokerHand2), Committee.GameResult.WHITE_WINS);

        // tie
        assertEquals(committee.judge(pokerHand1, pokerHand4), Committee.GameResult.TIE);
        assertEquals(committee.judge(pokerHand4, pokerHand1), Committee.GameResult.TIE);
    }

}
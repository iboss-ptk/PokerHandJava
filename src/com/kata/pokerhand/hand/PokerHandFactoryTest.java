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
}
package com.kata.pokerhand;

import com.kata.pokerhand.card.Card;
import com.kata.pokerhand.hand.PokerHand;
import com.kata.pokerhand.hand.PokerHandFactory;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public PokerHand parse(String input) {
        PokerHandFactory pokerHandFactory = new PokerHandFactory();
        String inputString = new String(input);
        Card[] cards = new Card[5];

        int i = 0;

        for (String cardString : inputString.split("\\s+")) {
            if(cardString.length() == 2) {
                cards[i] = new Card(cardString.charAt(0), cardString.charAt(1));
                i = i + 1;
            }
        }

        return pokerHandFactory.getPokerHand(cards);
    }
}

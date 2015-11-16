package com.kata.pokerhand.card;

import java.util.Arrays;
import java.util.List;

public class Card {
    private List<Character> acceptableSuitList = Arrays.asList('C', 'D', 'H', 'S');
    private List<Character> acceptableAndRankedValueList =
            Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');

    private Character value, suit;

    public Card(Character value, Character suit){
        if(!isAcceptableCardSuit(suit)) {
            throw new IllegalArgumentException("Card suit is invalid");
        }

        if(!isAcceptableCardValue(value)) {
            throw new IllegalArgumentException("Card value is invalid");
        }

        this.value = value;
        this.suit = suit;
    }

    private boolean isAcceptableCardSuit(Character suit) {
        return acceptableSuitList.contains(suit);
    }

    private boolean isAcceptableCardValue(Character value) {
        return acceptableAndRankedValueList.contains(value);
    }

    public boolean isHigherRankThan(Card anotherCard) {
        boolean isHigherValue =
                acceptableAndRankedValueList.indexOf(this.value) >
                acceptableAndRankedValueList.indexOf(anotherCard.value);

        return isHigherValue;
    }

    public boolean isDraw(Card anotherCard) {
        return this.value == anotherCard.value;
    }

    public boolean hasSameSuitAs(Card anotherCard) {
        return this.suit == anotherCard.suit;
    }

    public boolean hasSameValueAs(Card anotherCard) {
        return this.value == anotherCard.value;
    }

    public int valueDifferenceFrom(Card anotherCard) {
        int thisQuantifiedValue = acceptableAndRankedValueList.indexOf(this.value);
        int anotherCardQuantifiedValue = acceptableAndRankedValueList.indexOf(anotherCard.value);
        return thisQuantifiedValue - anotherCardQuantifiedValue;
    }

    public int getIntValue() {
        // start from 2
        return acceptableAndRankedValueList.indexOf(this.value) + 2;
    }

}

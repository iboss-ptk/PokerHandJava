package com.kata.pokerhand.hand;


import com.kata.pokerhand.card.Card;

public class FullHouse extends PokerHand implements LocalWinAgainstable<FullHouse> {
    public FullHouse(Card[] cards) {
        super(cards);
    }

    @Override
    public boolean isWinAgainstLocal(FullHouse anotherHand) {
        ThreeOfAKind thisAsThreeOfAKind = new ThreeOfAKind(this.handCards);
        ThreeOfAKind anotherAsThreeOfAKind = new ThreeOfAKind(anotherHand.handCards);
        return thisAsThreeOfAKind.isWinAgainstLocal(anotherAsThreeOfAKind);
    }
}

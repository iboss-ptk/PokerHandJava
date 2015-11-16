package com.kata.pokerhand.hand;

public interface localWinAgainstable<T extends PokerHand> {
    boolean isWinAgainstInSameHandClass(T anotherHand);
}

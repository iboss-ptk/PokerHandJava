package com.kata.pokerhand.hand;

public interface LocalWinAgainstable<T extends PokerHand> {
    boolean isWinAgainstLocal(T anotherHand);
}

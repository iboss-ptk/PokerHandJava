package com.kata.pokerhand;

import com.kata.pokerhand.hand.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Committee {
    private Map<Class, Integer> handRank = new HashMap();

    public enum GameResult { BLACK_WINS, WHITE_WINS, TIE }

    public Committee() {
        handRank.put(StraightFlush.class, 1);
        handRank.put(FourOfAKind.class, 2);
        handRank.put(FullHouse.class, 3);
        handRank.put(Flush.class, 4);
        handRank.put(Straight.class, 5);
        handRank.put(ThreeOfAKind.class, 6);
        handRank.put(TwoPairs.class, 7);
        handRank.put(Pair.class, 8);
        handRank.put(HighCard.class, 9);
    }

    public GameResult judge(PokerHand blackHand, PokerHand whiteHand) {
        if(isHandTie(blackHand, whiteHand)) {
            return GameResult.TIE;
        }
        if(blackHand.getClass().equals(whiteHand.getClass())) {
            return judgeSameHandType(blackHand, whiteHand);
        }
        return handRank.get(blackHand.getClass()) < handRank.get(whiteHand.getClass())
                ? GameResult.BLACK_WINS : GameResult.WHITE_WINS;
    }

    private <T extends PokerHand> GameResult judgeSameHandType(PokerHand blackHand, PokerHand whiteHand) {
        LocalWinAgainstable<T> localWinAgainstable1 = (LocalWinAgainstable<T>)blackHand;
        T anotherHand = (T)whiteHand;

        return localWinAgainstable1.isWinAgainstLocal(anotherHand) ? GameResult.BLACK_WINS : GameResult.WHITE_WINS;
    }

    private boolean isHandTie(PokerHand blackHand, PokerHand whiteHand) {
        int[] blackHandValueArray = Arrays
                .stream(blackHand.getHandCards())
                .sorted((c1, c2) -> Integer.compare(c1.getIntValue(), c2.getIntValue()))
                .mapToInt(c -> c.getIntValue())
                .toArray();

        int[] whiteHandValueArray = Arrays
                .stream(whiteHand.getHandCards())
                .sorted((c1, c2) -> Integer.compare(c1.getIntValue(), c2.getIntValue()))
                .mapToInt(c -> c.getIntValue())
                .toArray();

        for (int i = 0; i < blackHandValueArray.length; i++) {
            if(blackHandValueArray[i] != whiteHandValueArray[i]) {
                return false;
            }
        }

        return true;
    }
}

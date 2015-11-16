package com.kata.pokerhand.hand;

import com.kata.pokerhand.card.Card;

import java.util.Arrays;

public abstract class PokerHand {
    protected Card[] handCards;

    public PokerHand(Card[] cards) {
        if(!isValidCardAmount(cards)) {
            throw new IllegalArgumentException("A hand need five cards");
        }
        handCards = cards;
    }

    public Card highestValueCard() {
        return Arrays.stream(this.handCards)
            .reduce(this.handCards[0], (acc, curr) -> acc.isHigherRankThan(curr) ? acc : curr);
    }

    protected Card highestValueCard(Card excludedValueCard) {
        return Arrays.stream(this.handCards)
                .reduce(this.handCards[0], (acc, curr) ->
                        acc.isHigherRankThan(curr) || curr.isDraw(excludedValueCard) ? acc : curr);
    }

    private boolean isValidCardAmount(Card[] cards) {
        return cards.length == 5;
    }

    protected Card findRepresentativeCardOfAGroupOf(int number) {
        int count = 0;
        for(Card card : this.handCards) {
            for(Card comparingCard : this.handCards) {
                if (card.hasSameValueAs(comparingCard)) {
                    count = count + 1;
                }
                if (count == number) {
                    return card;
                }
            }
            count = 0;
        }
        throw new NullPointerException();
    }

    protected Card findRepresentativeCardOfAGroupOf(int number, Card excludedValueCard) {
        int count = 0;
        for(Card card : this.handCards) {
            for(Card comparingCard : this.handCards) {
                if (card.hasSameValueAs(excludedValueCard)) {
                    continue;
                }
                if (card.hasSameValueAs(comparingCard)) {
                    count = count + 1;
                }
                if (count == number) {
                    return card;
                }
            }
            count = 0;
        }
        throw new NullPointerException();
    }

    public Card[] getHandCards() {
        return handCards;
    }
}

package com.kata.pokerhand;

import com.kata.pokerhand.hand.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputParserTest {
    String input1 = "2H 5C AD 4S 2S";

    InputParser inputParser = new InputParser();

    @Test
    public void parseShouldReturnPokerHand() {
        assertEquals(inputParser.parse(input1).getClass(), Pair.class);
    }
}
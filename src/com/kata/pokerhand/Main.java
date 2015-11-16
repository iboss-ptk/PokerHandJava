package com.kata.pokerhand;

import com.kata.pokerhand.hand.PokerHand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Committee committee = new Committee();
        InputParser inputParser = new InputParser();

        System.out.print("Black: ");
        String blackHandInput = scanner.nextLine();
        PokerHand blackHand = inputParser.parse(blackHandInput);

        System.out.print("White: ");
        String whiteHandInput = scanner.nextLine();
        PokerHand whiteHand = inputParser.parse(whiteHandInput);

        Committee.GameResult gameResult = committee.judge(blackHand, whiteHand);

        if(gameResult == Committee.GameResult.TIE) {
            System.out.println("Tie.");
        } else if(gameResult == Committee.GameResult.BLACK_WINS) {
            System.out.println("Black wins. - with " + blackHand.getClass().getSimpleName());
        } else if(gameResult == Committee.GameResult.WHITE_WINS) {
            System.out.println("White wins. - with " + whiteHand.getClass().getSimpleName());
        }
    }
}

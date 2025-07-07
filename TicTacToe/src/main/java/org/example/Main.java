package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {
            TicTacToe game = new TicTacToe();

            while (!game.isGameEnded()) {
                System.out.println("Current Player: " + game.getCurrentPlayer().getMarker());
                game.getBoard().print();

                System.out.print("row (0-2): ");
                int row = scanner.nextInt();

                System.out.print("column (0-2): ");
                int col = scanner.nextInt();

                game.makeMove(row, col);
            }

            System.out.print("Do you want to play again? (y/n): ");
            scanner.nextLine(); // Restzeile abfangen
            String answer = scanner.nextLine();

            playAgain = answer.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
    }
}


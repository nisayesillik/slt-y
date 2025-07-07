package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        while (!game.isGameEnded()) {
            System.out.println("Current Player: " + game.getCurrentPlayer().getMarker());

            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            game.makeMove(row, col);
            game.getBoard().print();
        }

    }
}

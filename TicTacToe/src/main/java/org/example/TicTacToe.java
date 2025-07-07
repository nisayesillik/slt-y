package org.example;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private boolean gameEnded = false;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public boolean makeMove(int row, int col) {
        if (gameEnded) {
            System.out.println("Game has ended. Start a new game.");
            return false;
        }

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid coordinates.");
            return false;
        }

        if (board.isCellEmpty(row, col)) {
            board.place(row, col, currentPlayer.getMarker());
            System.out.println("Player " + currentPlayer.getMarker() + " placed at (" + row + ", " + col + ")");

            // Check for win/draw
            if (checkWin(currentPlayer.getMarker())) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                gameEnded = true;
            } else if (isDraw()) {
                board.print();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                switchCurrentPlayer();
            }

            return true;
        } else {
            System.out.println("Cell is already occupied. Choose another one.");
            return false;
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public boolean checkWin(char marker) {
        char[][] c = board.getCells();

        for (int i = 0; i < 3; i++) {
            // Reihen
            if (c[i][0] == marker && c[i][1] == marker && c[i][2] == marker) return true;
            // Spalten
            if (c[0][i] == marker && c[1][i] == marker && c[2][i] == marker) return true;
        }

        // Diagonalen
        return (c[0][0] == marker && c[1][1] == marker && c[2][2] == marker) ||
                (c[0][2] == marker && c[1][1] == marker && c[2][0] == marker);
    }

    public boolean isDraw() {
        char[][] c = board.getCells();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (c[i][j] == ' ')
                    return false;
        return true;
    }
}

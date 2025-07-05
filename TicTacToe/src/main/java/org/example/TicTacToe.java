package org.example;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid coordinates.");
            return;
        }

        if (board.isCellEmpty(row, col)) {
            board.place(row, col, currentPlayer.getMarker());
            System.out.println("Player " + currentPlayer.getMarker() + " placed at (" + row + ", " + col + ")");
            board.print();
            switchCurrentPlayer();
        } else {
            System.out.println("Cell is already occupied. Choose another one.");
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

}

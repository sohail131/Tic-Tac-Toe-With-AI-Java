package tictactoe;

public interface GameRules {
    void displayBoard();

    void makeMove();

    boolean checkWinner();
}

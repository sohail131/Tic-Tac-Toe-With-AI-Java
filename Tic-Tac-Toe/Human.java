package tictactoe;

public class Human extends TicTacToe implements GameRules {
    private final char symbol;
    public Human(char symbol) {
        this.symbol = symbol;

        setTable();
    }

    @Override
    public void displayBoard() {
        displayTable();
    }

    @Override
    public void makeMove() {
        humanMove(symbol);
    }

    @Override
    public boolean checkWinner() {
        return win(symbol);
    }
}

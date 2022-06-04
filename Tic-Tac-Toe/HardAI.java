package tictactoe;

public class HardAI extends TicTacToe implements GameRules {
    private final String difficultyLevel;
    private final char symbol;
    private final char opponentSymbol;
    private char[][] gameTable;

    public HardAI(String difficultyLevel, char symbol, char opponentSymbol) {
        this.difficultyLevel = difficultyLevel;
        this.symbol = symbol;
        this.opponentSymbol = opponentSymbol;

        setTable();
    }

    @Override
    public void displayBoard() {
        displayTable();
    }

    @Override
    public void makeMove() {
        System.out.println("Making move level \"" + difficultyLevel + "\"");

        gameTable = getTable();

        aiMove(makeHardMove(), symbol);
    }

    @Override
    public boolean checkWinner() {
        return win(symbol);
    }

    private int[] makeHardMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] moveCoordinates = {0, 0};

        for (int i = 0; i < gameTable.length; i++) {
            for (int j = 0; j < gameTable.length; j++) {
                if (gameTable[i][j] == ' ') {
                    gameTable[i][j] = symbol;

                    int currentScore = minimax(false);

                    gameTable[i][j] = ' ';

                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        moveCoordinates[0] = i;
                        moveCoordinates[1] = j;
                    }
                }
            }
        }

        return moveCoordinates;
    }

    private int minimax(boolean isMax) {
        if (win(symbol)) {
            return 1;
        } else if (win(opponentSymbol)) {
            return -1;
        } else if (gameFinished()) {
            return 0;
        } else {
            int bestScore;

            if (isMax) {
                bestScore = Integer.MIN_VALUE;

                for (int i = 0; i < gameTable.length; i++) {
                    for (int j = 0; j < gameTable.length; j++) {
                        if (gameTable[i][j] == ' ') {
                            gameTable[i][j] = symbol;

                            int score = minimax(false);

                            gameTable[i][j] = ' ';
                            bestScore = Math.max(score, bestScore);
                        }
                    }
                }
            } else {
                bestScore = Integer.MAX_VALUE;

                for (int i = 0; i < gameTable.length; i++) {
                    for (int j = 0; j < gameTable.length; j++) {
                        if (gameTable[i][j] == ' ') {
                            gameTable[i][j] = opponentSymbol;

                            int score = minimax(true);

                            gameTable[i][j] = ' ';
                            bestScore = Math.min(score, bestScore);
                        }
                    }
                }
            }

            return bestScore;
        }
    }
}

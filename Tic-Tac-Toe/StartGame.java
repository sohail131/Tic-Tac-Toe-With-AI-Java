package tictactoe;

import java.util.Locale;
import java.util.Scanner;

public class StartGame {
    private static final Scanner scanner = new Scanner(System.in);
    private String[] commands;
    private final TicTacToe[] gamePlayers = new TicTacToe[2];

    public void start() {
        gameCommands();

        if (commands.length == 3) {
            setPlayer();
            gameLoop();
        }
    }

    private void gameLoop() {
        int count = 0;

        while (true) {
            if (count % 2 == 0) {
                if (gamePlayers[0] instanceof EasyAI) {
                    if (computerTurn(0)) {
                        break;
                    }
                } else if (gamePlayers[0] instanceof MediumAI) {
                    if (mediumAITurn(0)) {
                        break;
                    }
                } else if (gamePlayers[0] instanceof HardAI) {
                    if (hardAITurn(0)) {
                        break;
                    }
                } else {
                    if (humanTurn(0)) {
                        break;
                    }
                }
            } else {
                if (gamePlayers[1] instanceof EasyAI) {
                    if (computerTurn(1)) {
                        break;
                    }
                } else if (gamePlayers[1] instanceof MediumAI) {
                    if (mediumAITurn(1)) {
                        break;
                    }
                } else if (gamePlayers[1] instanceof HardAI) {
                    if (hardAITurn(1)) {
                        break;
                    }
                } else {
                    if (humanTurn(1)) {
                        break;
                    }
                }
            }

            count++;
        }
    }

    private void gameCommands() {
        do {
            System.out.print("Input command: ");

            commands = scanner.nextLine().toLowerCase(Locale.ROOT).split("\\s+");

            if (commands.length == 3 || "exit".equals(commands[0])) {
                break;
            } else {
                System.out.println("Bad parameters!");
            }
        } while (true);
    }

    private void setPlayer() {
        if ("easy".equals(commands[1])) {
            gamePlayers[0] = new EasyAI(commands[1], 'X');
        } else if ("medium".equals(commands[1])) {
            gamePlayers[0] = new MediumAI(commands[1], 'X');
        } else if ("hard".equals(commands[1])) {
            gamePlayers[0] = new HardAI(commands[1], 'X', 'O');
        } else {
            gamePlayers[0] = new Human('X');
        }

        if ("easy".equals(commands[2])) {
            gamePlayers[1] = new EasyAI(commands[2], 'O');
        } else if ("medium".equals(commands[2])) {
            gamePlayers[1] = new MediumAI(commands[2], 'O');
        } else if ("hard".equals(commands[2])) {
            gamePlayers[1] = new HardAI(commands[2], 'O', 'X');
        } else {
            gamePlayers[1] = new Human('O');
        }
    }

    private boolean computerTurn(int index) {
        ((EasyAI) gamePlayers[index]).displayBoard();
        ((EasyAI) gamePlayers[index]).makeMove();

        if (((EasyAI) gamePlayers[index]).checkWinner()) {
            ((EasyAI) gamePlayers[index]).displayBoard();

            if (index == 0) {
                System.out.println("X wins");
            } else {
                System.out.println("O wins");
            }

            return true;
        } else if (gamePlayers[index].gameFinished()) {
            ((EasyAI) gamePlayers[index]).displayBoard();

            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }

    private boolean mediumAITurn(int index) {
        ((MediumAI) gamePlayers[index]).displayBoard();
        ((MediumAI) gamePlayers[index]).makeMove();

        if (((MediumAI) gamePlayers[index]).checkWinner()) {
            ((MediumAI) gamePlayers[index]).displayBoard();

            if (index == 0) {
                System.out.println("X wins");
            } else {
                System.out.println("O wins");
            }
            return true;
        } else if (gamePlayers[index].gameFinished()) {
            ((MediumAI) gamePlayers[index]).displayBoard();

            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }

    private boolean humanTurn(int index) {
        ((Human) gamePlayers[index]).displayBoard();
        ((Human) gamePlayers[index]).makeMove();

        if (((Human) gamePlayers[index]).checkWinner()) {
            ((Human) gamePlayers[index]).displayBoard();

            if (index == 0) {
                System.out.println("X wins");
            } else {
                System.out.println("O wins");
            }

            return true;
        } else if (gamePlayers[index].gameFinished()) {
            ((Human) gamePlayers[index]).displayBoard();

            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }

    private boolean hardAITurn(int index) {
        ((HardAI) gamePlayers[index]).displayBoard();
        ((HardAI) gamePlayers[index]).makeMove();

        if (((HardAI) gamePlayers[index]).checkWinner()) {
            ((HardAI) gamePlayers[index]).displayBoard();

            if (index == 0) {
                System.out.println("X wins");
            } else {
                System.out.println("O wins");
            }
            return true;
        } else if (gamePlayers[index].gameFinished()) {
            ((HardAI) gamePlayers[index]).displayBoard();

            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }
}

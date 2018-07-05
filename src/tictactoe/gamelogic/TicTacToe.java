package tictactoe.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicTacToe {

    private int turn;
    private int win;
    private final List<Integer> board;

    public TicTacToe() {
        win = 0;
        turn = 0;
        board = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            board.add(0);
        }
    }

    public void changeState(int x, int y) {
        board.set(x, y);
    }

    public int getWin() {
        return win;
    }

    public int checkWinCondition() {

        if ((board.get(0) == 1 && board.get(1) == 1 && board.get(2) == 1)
                || (board.get(0) == 1 && board.get(3) == 1 && board.get(6) == 1)
                || (board.get(0) == 1 && board.get(4) == 1 && board.get(8) == 1)
                || (board.get(4) == 1 && board.get(1) == 1 && board.get(7) == 1)
                || (board.get(3) == 1 && board.get(4) == 1 && board.get(5) == 1)
                || (board.get(2) == 1 && board.get(4) == 1 && board.get(6) == 1)
                ||( board.get(2) == 1 && board.get(5) == 1 && board.get(8) == 1)
                || (board.get(6) == 1 && board.get(7) == 1 && board.get(8) == 1)){
            win = 1;
        } else if ((board.get(0) == -1 && board.get(1) == -1 && board.get(2) == -1)
                || (board.get(0) == -1 && board.get(3) == -1 && board.get(6) == -1)
                || (board.get(0) == -1 && board.get(4) == -1 && board.get(8) == -1)
                || (board.get(4) == -1 && board.get(1) == -1 && board.get(7) == -1)
                || (board.get(3) == -1 && board.get(4) == -1 && board.get(5) == -1)
                || (board.get(2) == -1 && board.get(4) == -1 && board.get(6) == -1)
                ||( board.get(2) == -1 && board.get(5) == -1 && board.get(8) == -1)
                || (board.get(6) == -1 && board.get(7) == -1 && board.get(8) == -1)) {
            win = -1;
        }

        return win;
    }

    public void resetGame() {
        turn = 0;
        win = 0;
        for (int i = 0; i < board.size(); i++) {
            board.set(i, 0);
        }
    }

    public int getTurn() {
        return this.turn;
    }

    public void incrementTurn() {
        turn++;
    }
}

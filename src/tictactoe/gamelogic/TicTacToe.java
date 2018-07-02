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

    //is some cases it doesn't check win condition. Each if statement works when separated but all together don't work
    public int checkWinCondition() {
        if ((Objects.equals(board.get(0), board.get(1)) && Objects.equals(board.get(0), board.get(2)))
                || (Objects.equals(board.get(0), board.get(4)) && Objects.equals(board.get(0), board.get(8)))
                || (Objects.equals(board.get(0), board.get(3)) && Objects.equals(board.get(0), board.get(6)))) {
            win = board.get(0);
        } else if ((Objects.equals(board.get(4), board.get(1)) && Objects.equals(board.get(4), board.get(7)))
                || (Objects.equals(board.get(4), board.get(3)) && Objects.equals(board.get(4), board.get(5)))
                || (Objects.equals(board.get(4), board.get(2)) && Objects.equals(board.get(4), board.get(6)))) {
            win = board.get(4);
        } else if ((Objects.equals(board.get(8), board.get(2)) && Objects.equals(board.get(8), board.get(5)))
                || (Objects.equals(board.get(8), board.get(7)) && Objects.equals(board.get(8), board.get(6)))) {
            win = board.get(8);
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

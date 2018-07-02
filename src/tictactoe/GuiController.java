package tictactoe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tictactoe.gamelogic.TicTacToe;

public class GuiController implements Initializable {

    @FXML
    private ImageView pos00;
    @FXML
    private ImageView pos01;
    @FXML
    private ImageView pos02;
    @FXML
    private ImageView pos11;
    @FXML
    private ImageView pos12;
    @FXML
    private ImageView pos20;
    @FXML
    private ImageView pos21;
    @FXML
    private ImageView pos22;
    @FXML
    private Label oScore;
    @FXML
    private Label xScore;
    @FXML
    private Button nextRound;
    @FXML
    private ImageView pos10;
    @FXML
    private Label winner;

    private Image xImage;
    private Image oImage;
    private TicTacToe game;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        xImage = new Image("/tictactoe/x.png");
        oImage = new Image("/tictactoe/o.png");
        game = new TicTacToe();
        winner.setText("");
        nextRound.setDisable(true);

    }

    private void playObject(ImageView img, int x) {
        if (img.getImage() == null) {
            if (game.getTurn() % 2 == 0) {
                img.setImage(oImage);
                game.changeState(x, 1);
            } else {
                img.setImage(xImage);
                game.changeState(x, -1);
            }
            game.incrementTurn();
        }
    }

    private void cleanBoard() {
        pos00.setImage(null);
        pos01.setImage(null);
        pos02.setImage(null);
        pos10.setImage(null);
        pos11.setImage(null);
        pos12.setImage(null);
        pos20.setImage(null);
        pos21.setImage(null);
        pos22.setImage(null);
    }

    @FXML
    private void putPlayersSymbol(MouseEvent event) {
        if (game.getWin() == 0) {
            if ("pos00".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos00, 0);
            } else if ("pos01".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos01, 1);
            } else if ("pos02".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos02, 2);
            } else if ("pos10".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos10, 3);
            } else if ("pos11".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos11, 4);
            } else if ("pos12".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos12, 5);
            } else if ("pos20".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos20, 6);
            } else if ("pos21".equals(((ImageView) event.getSource()).getId())) {
                playObject(pos21, 7);
            } else { //pos22
                playObject(pos22, 8);
            }
            int isWin = game.checkWinCondition();
            if (isWin == 1) {
                oScore.setText(Integer.parseInt(oScore.getText()) + 1 + "");
                winner.setText("O Player won!");
                nextRound.setDisable(false);
            } else if (isWin == -1) {
                xScore.setText(Integer.parseInt(xScore.getText()) + 1 + "");
                winner.setText("X player won!");
                nextRound.setDisable(false);
            }
        }
    }

    @FXML
    private void restartGame(ActionEvent event) {
        oScore.setText("0");
        xScore.setText("0");
        game.resetGame();
        cleanBoard();
        winner.setText("");
        nextRound.setDisable(true);

    }

    @FXML
    private void playNextRound(ActionEvent event) {
        if (game.getWin() != 0) {
            game.resetGame();
            winner.setText("");
            cleanBoard();
            nextRound.setDisable(true);
        }
    }

}

package tictactoe;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TicTacToeLauncher extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/tictactoe/layout.fxml"));
        GridPane pane = loader.load();
        Scene scene = new Scene(pane, 890, 590);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("TicTacToe");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}

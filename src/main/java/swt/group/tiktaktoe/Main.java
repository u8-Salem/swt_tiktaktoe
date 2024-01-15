package swt.group.tiktaktoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TicTacToe.fxml")));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(400);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package swt.group.tiktaktoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        var root = (Parent) FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));

        var width = 310;
        var height = 310;

        var scene = new Scene(root, width, height);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setMinWidth(width);
        primaryStage.setMaxWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxHeight(height);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
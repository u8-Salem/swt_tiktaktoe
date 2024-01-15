package swt.group.tiktaktoe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class Controller implements AppControlInterface {
    @FXML
    private GridPane boardGrid;
    private Button[][] buttons;
    private final GameMaster gameMaster = new GameMaster();

    @Override
    public void startGame(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TicTacToe.fxml"));
        Parent root = loader.load();

        AppControlInterface controller = loader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();

        controller.initBoard();
    }

    @Override
    public void initBoard() {
        buttons = new Button[3][3];
        for (int i = 0; i < boardGrid.getChildren().size(); i++) {
            var button = (Button) boardGrid.getChildren().get(i);
            var x = i % 3;
            var y = i / 3;
            buttons[x][y] = button;

            button.setMinWidth(100); 
            button.setMinHeight(100);
            button.setMaxWidth(100); 
            button.setMaxHeight(100); 
        }
    }

    @Override
    @FXML
    public void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        int col = GridPane.getColumnIndex(clickedButton);
        int row = GridPane.getRowIndex(clickedButton);

        boolean turnSuccessful = gameMaster.doTurn(row, col, gameMaster.getState().getActivePlayer());
        clickedButton.setText(gameMaster.getState().getActivePlayer().toString());

        if (turnSuccessful) {
            gameMaster.nextRound();

            // Check on every click if the game is still "legal"
            GameTileType winner = gameMaster.getWinner();
            if (winner != GameTileType.None) {
                announceWinner(winner);
            } else if (gameMaster.getState().isBoardFull()) {
                announceDraw();
            }
        }
    }

    private void announceDraw() {
        Alert alert = new Alert(AlertType.INFORMATION, "The game resulted in a draw!", ButtonType.OK);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            resetBoard();
        }
    }

    private void announceWinner(GameTileType winner) {
        Alert alert = new Alert(AlertType.INFORMATION, winner.toString() + " won the game!", ButtonType.OK);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            resetBoard();
        }
    }

    @Override
    public void updateBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText(gameMaster.getState().getTile(row, col).toString());
            }
        }
    }

    @Override
    public void resetBoard() {
        gameMaster.reset();
        updateBoard();
    }

    @Override
    public void endGame() {
        System.exit(0);
    }
}

package swt.group.tiktaktoe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable {
    @FXML
    private GridPane boardGrid;

    private Button[][] buttons;

    private GameState gameState;
    private GameMaster gameMaster;

    public Controller() {
        gameState = new GameState();
        gameMaster = new GameMaster(gameState);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttons = new Button[3][3];
        for (int i = 0; i < boardGrid.getChildren().size(); i++) {
            var button = (Button) boardGrid.getChildren().get(i);

            var x = i % 3;
            var y = i / 3;

            buttons[x][y] = button;
        }
    }

    @FXML
    public void handleButtonClick(ActionEvent event) {
        var clickedButton = (Button) event.getSource();
        int col = GridPane.getColumnIndex(clickedButton);
        int row = GridPane.getRowIndex(clickedButton);

        if (gameState.getTile(row, col) != GameTileType.None)
            return;

        var activePlayer = gameState.getActivePlayer();

        clickedButton.setText(activePlayer.toString());

        var isWin = gameMaster.doTurn(row, col, activePlayer);
        if (isWin) {
            announceWinner(activePlayer);
        } else if (gameState.isBoardFull()) {
            announceDraw();
        } else {
            gameMaster.nextRound();
        }
    }

    private void announceDraw() {
        Alert alert = new Alert(AlertType.INFORMATION, "The game resulted in a draw!", ButtonType.OK);
        alert.showAndWait();

        resetBoard();
    }

    private void announceWinner(GameTileType winner) {
        Alert alert = new Alert(AlertType.INFORMATION, winner.toString() + " won the game!", ButtonType.OK);
        alert.showAndWait();

        resetBoard();
    }

    private void updateBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                var tile = gameState.getTile(row, col);

                buttons[row][col].setText(tile.toString());
            }
        }
    }

    private void resetBoard() {
        gameMaster.reset();
        updateBoard();
    }
}

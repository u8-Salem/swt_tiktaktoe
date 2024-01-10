package swt.group.tiktaktoe;
import javafx.scene.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Interface to link the GUI elements and the Game logic together
 * @version Prototype
 * @author Shantanu Biradar
 * */
public interface AppControlInterface {
    public void startGame(Stage primaryStage) throws IOException;
    public void initBoard();
    public void handleButtonClick(int row, int col);
    public void updateBoard();
    public void resetBoard();
    public void endGame();

}

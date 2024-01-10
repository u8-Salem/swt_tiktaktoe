package swt.group.tiktaktoe;
import javafx.scene.*;

/**
 * Interface to link the GUI elements and the Game logic together
 * @version Prototype
 * @author Shantanu Biradar
 * */
public interface AppControlInterface {
    public void initBoard();
    public void handleButtonClick();
    public void updateBoard();
    public void announceWinner();
    public void resetBoard();
    public void endGame();

}

package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
//import world.ucode.scenes.LoadGame;
import world.ucode.Scenes.NewGame;

import java.net.URL;
import java.util.ResourceBundle;

public class GameMenuController extends Controller{
    public GameMenuController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleNewGame() {
        NewGame scene = new NewGame(primaryStage);
    }

    @FXML
    private void HandleLoadGame() {
//        LoadGame scene = new LoadGame(primaryStage);
    }

    @FXML
    Button NewGameButton;
    @FXML
    Button LoadGameButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        NewGameButton.setOnMouseEntered(e -> NewGameButton.setStyle(styleHover));
        NewGameButton.setOnMouseExited(e -> NewGameButton.setStyle(style));
        LoadGameButton.setOnMouseEntered(e -> LoadGameButton.setStyle(styleHover));
        LoadGameButton.setOnMouseExited(e -> LoadGameButton.setStyle(style));
    }
}
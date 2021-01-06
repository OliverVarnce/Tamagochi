package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.Scenes.GameMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController extends Controller{
    public GameOverController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleRestart() {
        GameMenu menu = new GameMenu(primaryStage);
    }
    @FXML
    private void HandleExit() {
        System.exit(0);
    }
    @FXML
    Button RestartButton;
    @FXML
    Button ExitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RestartButton.setOnMouseEntered(e -> RestartButton.setStyle(styleHover));
        RestartButton.setOnMouseExited(e -> RestartButton.setStyle(style));
        ExitButton.setOnMouseEntered(e -> ExitButton.setStyle(styleHover));
        ExitButton.setOnMouseExited(e -> ExitButton.setStyle(style));
    }
}
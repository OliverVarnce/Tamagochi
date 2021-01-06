package world.ucode.Scenes;

import javafx.stage.Stage;
import world.ucode.Controllers.GameOverController;

public class GameOver extends GameScene {
    public GameOver(Stage primaryStage) {
        super(primaryStage, "/GameOver.fxml", new GameOverController(primaryStage));
    }
}
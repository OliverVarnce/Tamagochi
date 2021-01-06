package world.ucode.Scenes;

import javafx.stage.Stage;
import world.ucode.Controllers.LoadGameController;

public class LoadGame extends GameScene {
    public LoadGame(Stage primaryStage) {
        super(primaryStage, "/LoadGame.fxml", new LoadGameController(primaryStage));

    }
}
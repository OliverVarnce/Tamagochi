package world.ucode.Scenes;

import javafx.stage.Stage;
import world.ucode.Controllers.NewGameController;

public class NewGame extends GameScene {
    public NewGame(Stage primaryStage) {
        super(primaryStage, "/NewGame2.fxml", new NewGameController(primaryStage));
    }
}
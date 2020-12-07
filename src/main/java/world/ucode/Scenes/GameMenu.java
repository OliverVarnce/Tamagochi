package world.ucode.Scenes;

import javafx.stage.Stage;
import world.ucode.Controllers.GameMenuController;

public class GameMenu extends GameScene {
    public GameMenu(Stage primaryStage) {
        super(primaryStage, "/GameMenu.fxml", new GameMenuController(primaryStage));
    }
}

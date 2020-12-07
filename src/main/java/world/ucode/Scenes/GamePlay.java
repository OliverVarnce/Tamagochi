package world.ucode.Scenes;

import javafx.stage.Stage;
import world.ucode.Controllers.GamePlayController;
import world.ucode.Hero.Monkey;

public class GamePlay extends GameScene {
    public GamePlay(Stage primaryStage, Monkey monkey) {
        super(primaryStage, "/GamePlay.fxml", new GamePlayController(primaryStage, monkey));
    }
}
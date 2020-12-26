package world.ucode.Scenes;

import javafx.stage.Stage;
import world.ucode.Controllers.GamePlayController;
import world.ucode.Hero.Pet;

public class GamePlay extends GameScene {
    public GamePlay(Stage primaryStage, Pet pet) {
        super(primaryStage, "/GamePlay.fxml", new GamePlayController(primaryStage, pet));
    }
}
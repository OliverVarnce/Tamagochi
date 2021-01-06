package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import world.ucode.Hero.Pet;
import world.ucode.Hero.HeroType;
import world.ucode.Scenes.GameMenu;
import world.ucode.Scenes.GamePlay;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController extends Controller {
    public NewGameController(Stage primaryStage) {
        super(primaryStage);
    }
    @FXML
    TextField InputName;
    GamePlay game;

    @FXML
    private void HandleDog() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Pet(HeroType.DOG, name));
    }

    @FXML
    private void HandleMonkey() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Pet(HeroType.MONKEY, name));
    }

    @FXML
    private void HandleBackNewGame() {
        GameMenu menu = new GameMenu(primaryStage);
    }

    @FXML
    Button BackNewGame;
    @FXML
    Button Dog;
    @FXML
    Button Monkey;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BackNewGame.setOnMouseEntered(e -> BackNewGame.setStyle(styleBackHover));
        BackNewGame.setOnMouseExited(e -> BackNewGame.setStyle(styleBack));
        Dog.setOnMouseEntered(e -> Dog.setStyle(styleHover));
        Dog.setOnMouseExited(e -> Dog.setStyle(style));
        Monkey.setOnMouseEntered(e -> Monkey.setStyle(styleHover));
        Monkey.setOnMouseExited(e -> Monkey.setStyle(style));
    }
}
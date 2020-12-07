package world.ucode.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import world.ucode.Hero.Monkey;
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
    private void HandleBob() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Monkey(HeroType.BOB, name));
    }

    @FXML
    private void HandleKevin() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Monkey(HeroType.KEVIN, name));
    }

    @FXML
    private void HandleStuart() {
        String name = InputName.getText();
        if (name.length() != 0)
            game = new GamePlay(primaryStage, new Monkey(HeroType.STUART, name));
    }

    @FXML
    private void HandleBackNewGame() {
        GameMenu menu = new GameMenu(primaryStage);
    }

    @FXML
    Button BackNewGame;
    @FXML
    Button Bob;
    @FXML
    Button Kevin;
    @FXML
    Button Stuart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BackNewGame.setOnMouseEntered(e -> BackNewGame.setStyle(styleHover));
        BackNewGame.setOnMouseExited(e -> BackNewGame.setStyle(style));
        Bob.setOnMouseEntered(e -> Bob.setStyle(styleHover));
        Bob.setOnMouseExited(e -> Bob.setStyle(style));
        Kevin.setOnMouseEntered(e -> Kevin.setStyle(styleHover));
        Kevin.setOnMouseExited(e -> Kevin.setStyle(style));
        Stuart.setOnMouseEntered(e -> Stuart.setStyle(styleHover));
        Stuart.setOnMouseExited(e -> Stuart.setStyle(style));
    }
}
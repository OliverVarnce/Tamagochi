package world.ucode.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import world.ucode.DataBase;
import world.ucode.Hero.Pet;
import world.ucode.Scenes.GameMenu;
import world.ucode.Scenes.GamePlay;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoadGameController extends Controller {
    @FXML
    ChoiceBox<String> LoadMinions;
    @FXML
    Button SelectButton;
    @FXML
    Button BackLoadGame;

    public LoadGameController(Stage primaryStage) {
        super(primaryStage);
    }

    @FXML
    private void HandleSelect() {
        String selectedChoice = LoadMinions.getSelectionModel().getSelectedItem();
        ResultSet resSet;
        try {
            resSet = DataBase.ReadDBPet(selectedChoice);
            GamePlay game = new GamePlay(primaryStage, new Pet(resSet));
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("SQLException Load Game");
        }
    }

    @FXML
    private void HandleBack() {
        GameMenu menu = new GameMenu(primaryStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ResultSet resSet;
        try {
            resSet = DataBase.ReadDBNames();
            List<String> names = new ArrayList<String>();
            while (resSet.next())
                names.add(resSet.getString("name"));
            ObservableList<String> availableChoices = FXCollections.observableArrayList(names);
            LoadMinions.setItems(availableChoices);
            SelectButton.setOnMouseEntered(e -> SelectButton.setStyle(styleHover));
            SelectButton.setOnMouseExited(e -> SelectButton.setStyle(style));
//            BackLoadGame.setOnMouseEntered(e -> BackLoadGame.setStyle(styleHover));
//            BackLoadGame.setOnMouseExited(e -> BackLoadGame.setStyle(style));
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
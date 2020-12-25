package world.ucode.Controllers;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public abstract class Controller implements Initializable {
    protected String style = "-fx-background-color:black;";
    protected String styleHover = "-fx-background-color:grey;-fx-border-color: black;";
    protected Stage primaryStage;
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
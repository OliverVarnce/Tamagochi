package world.ucode.Controllers;

import javafx.fxml.Initializable;
import javafx.stage.Stage;

public abstract class Controller implements Initializable {
    protected String style = "-fx-background-color:black;";
    protected String styleHover = "-fx-background-color:grey; -fx-border-color: black;";

    protected String stylePlay = "-fx-background-color: transparent; -fx-background-image: url(./Images/play.png);";
    protected String stylePlayHover = "-fx-background-color: transparent; -fx-background-image: url(./Images/play_hover.png)";
    protected String styleFeed = "-fx-background-color: transparent; -fx-background-image: url(./Images/feed.png)";
    protected String styleFeedHover = "-fx-background-color: transparent; -fx-background-image: url(./Images/feed_hover.png)";
    protected String styleWater = "-fx-background-color: transparent; -fx-background-image: url(./Images/water.png)";
    protected String styleWaterHover = "-fx-background-color: transparent; -fx-background-image: url(./Images/water_hover.png)";
    protected String styleMedicine = "-fx-background-color: transparent; -fx-background-image: url(./Images/medicine.png)";
    protected String styleMedicineHover = "-fx-background-color: transparent; -fx-background-image: url(./Images/medicine_hover.png)";
    protected String styleCleanup = "-fx-background-color: transparent; -fx-background-image: url(./Images/clean_up.png)";
    protected String styleCleanupHover = "-fx-background-color: transparent; -fx-background-image: url(./Images/cleanup_png.png)";
    protected String styleBack = "-fx-background-color: transparent; -fx-background-image: url(./Images/back.png)";
    protected String styleBackHover = "-fx-background-color: transparent; -fx-background-image: url(./Images/back_hover.png)";

    protected Stage primaryStage;
    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
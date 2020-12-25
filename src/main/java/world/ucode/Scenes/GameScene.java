package world.ucode.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class GameScene {
    private Scene scene;
    public Parent PaneRoot;
    GameScene(Stage primaryStage, String fxmlName, Object Controller) {
        try {
            FXMLLoader loader = new
                    FXMLLoader(getClass().getResource("/FXML/" + fxmlName));
            loader.setController(Controller);
            PaneRoot = loader.load();
            scene = new Scene(PaneRoot, 800, 913);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
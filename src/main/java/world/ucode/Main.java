package world.ucode;
import javafx.application.Application;
import javafx.stage.Stage;
import world.ucode.scenes.GameMenu;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        try {
            DataBase.Conn();
            DataBase.CreateDB();
            primaryStage.setTitle("tamagotchi");
            GameMenu menu = new GameMenu(primaryStage);
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch(Exception e){
            System.err.println("Exception");
        }
    }
}
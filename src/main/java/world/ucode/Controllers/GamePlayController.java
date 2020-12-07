package world.ucode.Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import world.ucode.DataBase;
import world.ucode.Hero.Monkey;
import world.ucode.Hero.HeroAction;
import world.ucode.Scenes.GameMenu;
import world.ucode.Animation.MonkeyAnimation;
//import world.ucode.Scenes.GameOver;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GamePlayController extends Controller{
    Monkey monkey;
    MonkeyAnimation animation;
    Timeline LiveCycle;

    @FXML
    ImageView AnimationView;

    @FXML
    ImageView MonkeyView;

    @FXML
    Label MonkeyName;

    public GamePlayController(Stage primaryStage, Monkey monkey) {
        super(primaryStage);
        this.monkey = monkey;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::HandleClose);
        ButtonSetStyle();
        MonkeyName.setText(monkey.GetType().toString());
        MonkeyName.setAlignment(Pos.TOP_CENTER);
        this.animation = new MonkeyAnimation(monkey.GetType(),AnimationView, MonkeyView);
        startLiveCycle();
    }

    private void HandleClose(WindowEvent event){
        LiveCycle.stop();
        SaveMonkey();
    }

    private void SaveMonkey(){
        try {
            DataBase.WriteDB(monkey.GetType().toString(), monkey.GetName(), monkey.GetHealth(), monkey.GetHappiness(),
                    monkey.GetHunger(), monkey.GetThirst(), monkey.GetCleanliness());;
        }
        catch (SQLException ignored) {
            System.err.println("SQLException");
        }
    }
    private void SetProgress() {
        ProgressBarHealth.setProgress(monkey.GetHealth()/monkey.GetMaxHealth());
        ProgressBarHappiness.setProgress(monkey.GetHappiness()/10);
        ProgressBarHunger.setProgress(monkey.GetHunger()/10);
        ProgressBarThirst.setProgress(monkey.GetThirst()/10);
        ProgressBarCleanliness.setProgress(monkey.GetCleanliness()/10);
    }
    @FXML
    private void HandleBackGamePlay() {
        LiveCycle.stop();
        SaveMonkey();
        GameMenu menu = new GameMenu(primaryStage);
    }
    @FXML
    ProgressBar ProgressBarHealth;
    @FXML
    ProgressBar ProgressBarHappiness;
    @FXML
    ProgressBar ProgressBarHunger;
    @FXML
    ProgressBar ProgressBarThirst;
    @FXML
    ProgressBar ProgressBarCleanliness;

    @FXML
    private void HandlePlay() throws InvocationTargetException, IllegalAccessException {
        monkey.ActionHandler(HeroAction.PLAY, monkey);
        animation.HandleAnimation(HeroAction.PLAY);
    }

    @FXML
    private void HandleFeed() throws InvocationTargetException, IllegalAccessException {
        monkey.ActionHandler(HeroAction.FEED, monkey);
        animation.HandleAnimation(HeroAction.FEED);
    }

    @FXML
    private void HandleGiveWater() throws InvocationTargetException, IllegalAccessException {
        monkey.ActionHandler(HeroAction.GIVE_WATER, monkey);
        animation.HandleAnimation(HeroAction.GIVE_WATER);
    }

    @FXML
    private void HandleGiveMedicine() throws InvocationTargetException, IllegalAccessException {
        monkey.ActionHandler(HeroAction.GIVE_MEDICINE, monkey);
        animation.HandleAnimation(HeroAction.GIVE_MEDICINE);
    }

    @FXML
    private void HandleCleanUp() throws InvocationTargetException, IllegalAccessException {
        monkey.ActionHandler(HeroAction.CLEAN_UP, monkey);
        animation.HandleAnimation(HeroAction.CLEAN_UP);
    }

    private void startLiveCycle() {
        LiveCycle = new Timeline();
        LiveCycle.setCycleCount(Timeline.INDEFINITE);

        LiveCycle.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (monkey.LiveCycle() == -1) {
                            try {
                                DataBase.DeleteDB(monkey.GetName());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            LiveCycle.stop();
                            //GameOver menu = new GameOver(primaryStage);
                        }
                        SetProgress();
                    }
                }));
        LiveCycle.play();
    }

    @FXML
    Button BackGamePlay;
    @FXML
    Button PlayButton;
    @FXML
    Button FeedButton;
    @FXML
    Button GiveWaterButton;
    @FXML
    Button GiveMedicineButton;
    @FXML
    Button CleanUpButton;

    private void ButtonSetStyle() {
        BackGamePlay.setOnMouseEntered(e -> BackGamePlay.setStyle(styleHover));
        BackGamePlay.setOnMouseExited(e -> BackGamePlay.setStyle(style));
        PlayButton.setOnMouseEntered(e -> PlayButton.setStyle(styleHover));
        PlayButton.setOnMouseExited(e -> PlayButton.setStyle(style));
        FeedButton.setOnMouseEntered(e -> FeedButton.setStyle(styleHover));
        FeedButton.setOnMouseExited(e -> FeedButton.setStyle(style));
        GiveWaterButton.setOnMouseEntered(e -> GiveWaterButton.setStyle(styleHover));
        GiveWaterButton.setOnMouseExited(e -> GiveWaterButton.setStyle(style));
        GiveMedicineButton.setOnMouseEntered(e -> GiveMedicineButton.setStyle(styleHover));
        GiveMedicineButton.setOnMouseExited(e -> GiveMedicineButton.setStyle(style));
        CleanUpButton.setOnMouseEntered(e -> CleanUpButton.setStyle(styleHover));
        CleanUpButton.setOnMouseExited(e -> CleanUpButton.setStyle(style));
    }
}

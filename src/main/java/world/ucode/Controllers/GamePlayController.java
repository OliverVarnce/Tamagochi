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
import world.ucode.Hero.Pet;
import world.ucode.Hero.HeroAction;
import world.ucode.Scenes.GameMenu;
import world.ucode.Animation.PetAnimation;
import world.ucode.Scenes.GameOver;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GamePlayController extends Controller{
    Pet pet;
    PetAnimation animation;
    Timeline LiveCycle;

    @FXML
    ImageView AnimationView;

    @FXML
    ImageView PetView;

    @FXML
    Label PetName;

    public GamePlayController(Stage primaryStage, Pet pet) {
        super(primaryStage);
        this.pet = pet;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::HandleClose);
        ButtonSetStyle();
        this.animation = new PetAnimation(pet.GetType(),AnimationView, PetView);
        startLiveCycle();
    }

    private void HandleClose(WindowEvent event){
        LiveCycle.stop();
        SavePet();
    }

    private void SavePet(){
        try {
            DataBase.WriteDB(pet.GetType().toString(), pet.GetName(), pet.GetHealth(), pet.GetHappiness(),
                    pet.GetHunger(), pet.GetThirst(), pet.GetCleanliness());;
        }
        catch (SQLException ignored) {
            System.err.println("SQLException");
        }
    }
    private void SetProgress() {
        ProgressBarHealth.setProgress(pet.GetHealth()/pet.GetMaxHealth());
        ProgressBarHappiness.setProgress(pet.GetHappiness()/10);
        ProgressBarHunger.setProgress(pet.GetHunger()/10);
        ProgressBarThirst.setProgress(pet.GetThirst()/10);
        ProgressBarCleanliness.setProgress(pet.GetCleanliness()/10);
    }
    @FXML
    private void HandleBackGamePlay() {
        LiveCycle.stop();
        SavePet();
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
    private void HandleFeed() throws InvocationTargetException, IllegalAccessException {
        pet.ActionHandler(HeroAction.FEED, pet);
        animation.HandleAnimation(HeroAction.FEED);
    }

    @FXML
    private void HandlePlay() throws InvocationTargetException, IllegalAccessException {
        pet.ActionHandler(HeroAction.PLAY, pet);
        animation.HandleAnimation(HeroAction.PLAY);
    }

    @FXML
    private void HandleGiveWater() throws InvocationTargetException, IllegalAccessException {
        pet.ActionHandler(HeroAction.GIVE_WATER, pet);
        animation.HandleAnimation(HeroAction.GIVE_WATER);
    }

    @FXML
    private void HandleGiveMedicine() throws InvocationTargetException, IllegalAccessException {
        pet.ActionHandler(HeroAction.GIVE_MEDICINE, pet);
        animation.HandleAnimation(HeroAction.GIVE_MEDICINE);
    }

    @FXML
    private void HandleCleanUp() throws InvocationTargetException, IllegalAccessException {
        pet.ActionHandler(HeroAction.CLEAN_UP, pet);
        animation.HandleAnimation(HeroAction.CLEAN_UP);
    }

    private void startLiveCycle() {
        LiveCycle = new Timeline();
        LiveCycle.setCycleCount(Timeline.INDEFINITE);

        LiveCycle.getKeyFrames().add(
                new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (pet.LiveCycle() == -1) {
                            try {
                                DataBase.DeleteDB(pet.GetName());
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            LiveCycle.stop();
                            GameOver menu = new GameOver(primaryStage);
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
        BackGamePlay.setOnMouseEntered(e -> BackGamePlay.setStyle(styleBackHover));
        BackGamePlay.setOnMouseExited(e -> BackGamePlay.setStyle(styleBack));
        PlayButton.setOnMouseEntered(e -> PlayButton.setStyle(stylePlayHover));
        PlayButton.setOnMouseExited(e -> PlayButton.setStyle(stylePlay));
        FeedButton.setOnMouseEntered(e -> FeedButton.setStyle(styleFeedHover));
        FeedButton.setOnMouseExited(e -> FeedButton.setStyle(styleFeed));
        GiveWaterButton.setOnMouseEntered(e -> GiveWaterButton.setStyle(styleWaterHover));
        GiveWaterButton.setOnMouseExited(e -> GiveWaterButton.setStyle(styleWater));
        GiveMedicineButton.setOnMouseEntered(e -> GiveMedicineButton.setStyle(styleMedicineHover));
        GiveMedicineButton.setOnMouseExited(e -> GiveMedicineButton.setStyle(styleMedicine));
        CleanUpButton.setOnMouseEntered(e -> CleanUpButton.setStyle(styleCleanupHover));
        CleanUpButton.setOnMouseExited(e -> CleanUpButton.setStyle(styleCleanup));
    }
}

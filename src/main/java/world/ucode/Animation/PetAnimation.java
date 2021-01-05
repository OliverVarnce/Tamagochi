package world.ucode.Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.Hero.HeroType;
import world.ucode.Hero.HeroAction;


public class PetAnimation {
    HeroType type;
    private final ImageView AnimationView;
    private final Timeline timeline;

    public PetAnimation(HeroType type, ImageView AnimationView, ImageView PetView) {
        this.AnimationView = AnimationView;
        this.type = type;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(4), actionEvent -> AnimationView.setVisible(false)));
        AnimationView.setVisible(false);
        PetView.setImage(new Image("/Images/" + type.toString() + "/" + type.toString() + ".gif"));
    }

    public void HandleAnimation(HeroAction action) {
        AnimationView.setImage(GetImage(action));
        AnimationView.setVisible(true);
        AnimationView.setX(200.00);
        AnimationView.setY(200.00);
        AnimationView.setFitHeight(400.00);
        AnimationView.setFitWidth(10000.00);
        timeline.play();
    }

    private Image GetImage(HeroAction action) {
        return new Image("/Images/" + type.toString() + "/" + action.toString() + ".gif", 250, 200, false, false);

    }
}

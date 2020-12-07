package world.ucode.Animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.Hero.HeroType;
import world.ucode.Hero.HeroAction;


public class MonkeyAnimation {
    HeroType type;
    private final ImageView AnimationView;
    private final Timeline timeline;


    public MonkeyAnimation(HeroType type, ImageView AnimationView, ImageView MonkeyView) {
        this.AnimationView = AnimationView;
        this.type = type;
        this.timeline = new Timeline(new KeyFrame(Duration.seconds(4), actionEvent -> AnimationView.setVisible(false)));
        AnimationView.setVisible(false);
        MonkeyView.setImage(new Image("/Images/" + type.toString() + "/" + type.toString() + ".gif"));
    }

    public void HandleAnimation(HeroAction action) {
        AnimationView.setImage(GetImage(action));
        AnimationView.setVisible(true);
        timeline.play();
    }

    private Image GetImage(HeroAction action) {
        return new Image("/Images/" + type.toString() + "/" + action.toString() + ".gif", 800, 600, false, false);
    }
}

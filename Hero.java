import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {

    public Hero() {
        super(20, 245, "heros");
        this.getSpriteSheet().setViewport(new Rectangle2D(0,0,75,100));
    }


    @Override
    public ImageView getSpriteSheet() {
        return this.spriteSheet;
    }
}


import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private  Camera camera;
    private staticThing leftBack;
    private staticThing rightBack;
    private Hero hero;

    public GameScene(Parent parent, double width, double height, boolean depthBuffer) {
        super(parent, width, height, depthBuffer);
        this.leftBack= new staticThing(0,0,"desert");
        this.rightBack= new staticThing(800,0,"desert");
        this.hero = new Hero();
        Camera cam1 = new Camera();

        this.getLeftBack().getImageView().setViewport( new Rectangle2D(0,0,0,0));
        this.getRightBack().getImageView().setViewport( new Rectangle2D(0,0,0,0));
        this.getHero().getSpriteSheet().setViewport( new Rectangle2D(0,0,0,0));

    }

    public Hero getHero(){return this.hero;}
    public staticThing getLeftBack(){return this.leftBack;}
    public staticThing getRightBack(){return this.rightBack;}

    }






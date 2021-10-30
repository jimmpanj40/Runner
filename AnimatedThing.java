import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    
    private double x;
    private double y;
    public ImageView spriteSheet;
    private int attitude;

    private int index;
    private double duration = 30;
    private int indexMax = 5;
    private double l;
    private double h;
    private double offset = 30;

    public AnimatedThing(double x, double y, String filename) {
        Image thisSpringSheet = new Image("/Images/"+filename+".png");
        this.spriteSheet=new ImageView(thisSpringSheet);
        this.spriteSheet.setX(x);
        this.spriteSheet.setY(y);
        this.x=x;
        this.y=y;
        this.setIndex(0);


    }

    //Setter
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setIndex(int index) {this.index = index;}

    //constructeur


    //Getter
   
    public double getX() {return x;}

    public double getY() {return y;}

    public double getIndex() {return index;}

    public abstract ImageView getSpriteSheet();
}

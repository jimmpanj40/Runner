import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    private ImageView imageview;

    public staticThing(double x, double y, String fileName){
        Image image = new Image("/Images/"+fileName+".png"); // Image récupère l'image d'adresse : "/Images/"+fileName+".png"
        this.imageview = new ImageView(image); // On crée une image à voir
        this.imageview.setX(x); // On attribue x à imageview
        this.imageview.setY(y); // y
        this.x=x;
        this.y=y;
    }
    
// getters
    public ImageView getImageView(){return imageview;}
    public double getX() {return this.x;}
// setter
    public void setX(double x) {this.x=x;}
}

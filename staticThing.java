

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {

    private double x;
    private double y;
    private ImageView imageview;

    public staticThing(double x, double y, String fileName){
        Image image = new Image("/Images/"+fileName+".png");
        this.imageview = new ImageView(image);
        this.imageview.setX(x);
        this.imageview.setY(y);

        this.x=x;
        this.y=y;

    }
    public ImageView getImageView(){
        return imageview;
    }

}

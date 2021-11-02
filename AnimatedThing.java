import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    
    private double x;
    private double y;
    public ImageView spriteSheet;
    private int attitude;

    private int index=0;
    private double duration = 30;
    private int indexMax = 5;
    private double l;
    private double h;
    private double offset = 30;

    //constructeur
    public AnimatedThing(double x, double y, String filename) {
        Image thisSpringSheet = new Image("/Images/"+filename+".png"); // Attribue à Image l'image animée (notre Hero)
        this.spriteSheet=new ImageView(thisSpringSheet); // création de l'image à voir
        this.spriteSheet.setX(x);
        this.spriteSheet.setY(y);
        spriteSheet.setViewport( new Rectangle2D(0,0,85,100)); // Rectangle2D crée un cadre 2D sur spritesheet, partant de (v,v1) et longueur v3 et de hauteur v4
        this.x=x;
        this.y=y;
    }
    //Méthode
    public void update(long time){ // permet d'actualiser l'image animée
        int newindex = getIndex(); //Index permet de pointer les 6 positions différentes de notre Hero
        if (newindex==5){setIndex(0);}
        else{setIndex(newindex+1);}
        x= getX();
        //System.out.println(i);
        spriteSheet.setViewport( new Rectangle2D(this.index*85,0,85,100)); // On affiche la nouvelle position du Hero à chaque appel de update
    }
    //Setter
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setIndex(int index) {this.index = index;}

    //Getter
    public double getX() {return x;}
    public double getY() {return y;}
    public int getIndex() {return index;}
    public abstract ImageView getSpriteSheet();
}


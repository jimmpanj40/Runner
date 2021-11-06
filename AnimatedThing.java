import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public abstract class AnimatedThing {
    Random rand = new Random();
    private double x_hero;
    private double y_hero;
    private double x_foe;
    private double y_foe;
    public ImageView spriteSheet_hero;

    public ImageView spriteSheet_foe;

    private int attitude;

    private int runIndex=0;



    private int jumpIndex=0;
    private double duration = 30;
    private int runIndexMax = 5;
    private int jumpIndexMax=2;
    private double l;
    private double h;
    private double offset = 30;
    public static int jumpOk=0;



    //constructeur
    public AnimatedThing(double x, double y, String filename) {
        Image thisSpringSheet_hero = new Image("/Images/heros.png"); // Attribue à Image l'image animée (notre Hero)
        this.spriteSheet_hero=new ImageView(thisSpringSheet_hero); // création de l'image à voir
        this.spriteSheet_hero.setX(x);
        this.spriteSheet_hero.setY(y);
        spriteSheet_hero.setViewport( new Rectangle2D(0,0,85,100)); // Rectangle2D crée un cadre 2D sur spritesheet, partant de (v,v1) et longueur v3 et de hauteur v4
        setXHero(x);
        setYHero(y);

        Image thisSpringSheet_foe = new Image("/Images/foes.png");
        this.spriteSheet_foe=new ImageView(thisSpringSheet_foe); // création de l'image à voir
        this.spriteSheet_foe.setX(x);
        this.spriteSheet_foe.setY(y);
        spriteSheet_foe.setViewport( new Rectangle2D(0,0,85,100)); // Rectangle2D crée un cadre 2D sur spritesheet, partant de (v,v1) et longueur v3 et de hauteur v4
        setXFoe(x);
        setYFoe(y);


    }
    //Méthode
    public void update(long time){ // permet d'actualiser l'image animée
        int newindex;
        if(jumpOk==0) { // Etat où on ne saute pas => Il court
            newindex = getRunIndex(); //Index permet de pointer les 6 positions différentes de notre Hero
            if (newindex == runIndexMax) {
                setRunIndex(0);
            } else {
                setRunIndex(newindex + 1);
            }
            x_hero = getXHero();
            //System.out.println(i);
            spriteSheet_hero.setViewport(new Rectangle2D(getRunIndex() * 85, 0, 85, 100)); // On affiche la nouvelle position du Hero à chaque appel de update
        }
        else { //Etat où on saute
            newindex = getJumpIndex();
            if (newindex == jumpIndexMax) {
                setJumpIndex(0);
                jumpOk = 0;
            }
            else {
                x_hero = getXHero();
                //System.out.println(i);
                spriteSheet_hero.setViewport(new Rectangle2D(getJumpIndex() * 85, 160, 85, 100)); // On affiche la nouvelle position du Hero à chaque appel de update
                setJumpIndex(newindex + 1);
            }
        }
    }
    int foe_count=0; //compteur d'apparition d'un ennemi
    int foe_countMax=10; // Fréquence d'apparation d'un ennemi
    boolean ennemi= false; //Présence d'un ennemi
    int ennemi_index=0; //pointe le rang de l'ennemi
    int speed=6;
    public void foeSummoning(long time){

        if(ennemi) {
            double position = getXFoe();
            if (position>20){
                this.spriteSheet_foe.setX(position-speed); //On modifie le x associé à l'image dans le background de gauche
                setXFoe( (position- speed));
                spriteSheet_foe.setViewport(new Rectangle2D( 120*ennemi_index, 20, 110, 170)); // On affiche la nouvelle position du Hero à chaque appel de update
            }
            else{ennemi=false;
            foe_count=0;}
        }
        else{
            if (foe_count<foe_countMax) {
                foe_count = foe_count+1;
            }
            else{
                ennemi= true;
                ennemi_index = rand.nextInt(9);
                setXFoe(500);
                System.out.println(ennemi_index);

            }
        }
    }


    //Setter
    public void setXHero(double x) {this.x_hero = x;}
    public void setYHero(double y) {this.y_hero = y;}
    public void setXFoe(double x) {this.x_foe = x;}
    public void setYFoe(double y) {this.y_foe = y;}
    public void setRunIndex(int runIndex) {this.runIndex = runIndex;}
    public void setJumpIndex(int jumpIndex) {this.jumpIndex = jumpIndex;}



    //Getter
    public double getXHero() {return x_hero;}
    public double getYHero() {return y_hero;}
    public double getXFoe() {return x_foe;}
    public double getYFoe() {return y_foe;}
    public int getRunIndex() {return runIndex;}
    public int getJumpIndex() {return jumpIndex;}

    public abstract ImageView getSpriteSheet();
}

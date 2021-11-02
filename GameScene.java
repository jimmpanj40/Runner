import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScene extends Scene {
    private  Camera cam1;
    private static staticThing leftBack;
    private static staticThing rightBack;
    private Hero hero; //
    private int slow=0;

    public GameScene(Parent parent, double width, double height, boolean depthBuffer) {
        super(parent, width, height, depthBuffer);
        this.leftBack= new staticThing(0,0,"desert"); //création du BackGround de gauche
        this.rightBack= new staticThing(800,0,"desert"); // " " de droite
        this.hero = new Hero();  // création d'un Hero
        //Camera cam1 = new Camera(); // Création d'une caméra

        AnimationTimer timer= new AnimationTimer(){ //création d'un Timer qui actualise les affichages
            public void handle(long time){
                slow+=1; // Slow permet de ralentir la course du joueur
                if (slow%3==0) { //On divise la vitesse de défilement par 3, à tester sans slow, càd "slow%1==0"
                    hero.update(time); // actualise la position du Hero
                    //cam1.update(time); // actualise la position de la caméra, mais ça semble useless à notre niveau
                    GameScene.update(time); // actualise le Background
                    slow=0;
                }
            }
        };
        timer.start(); // Lancement du Timer
    }

    public static void update(long time){ // actualise le background
        double x1= leftBack.getX();
        double x2= rightBack.getX();
        if(x1<4){ //prendre x<4 au lieu de 0 permet d'éviter un freeze de l'écran du au changement de background
        //Si x1<0, on affiche le back ground du début
            leftBack.getImageView().setX(800);
            leftBack.setX(800);
            rightBack.getImageView().setX(0);
            rightBack.setX(0);
        }
        else{ // On défile background vers l'arrière
            leftBack.getImageView().setX(x1-2); //On modifie le x associé à l'image dans le background de gauche
            leftBack.setX( (x1 - 6)); // On modifie la x associé au background de gauche qui est modifié. ligne 61 on aura x1=x1-6
            rightBack.getImageView().setX(x2-2); // " " gauche-->droite
            rightBack.setX( (x2-6));
        }
    }
    // Getters
    public Hero getHero(){return this.hero;}
    public staticThing getLeftBack(){return this.leftBack;}
    public staticThing getRightBack(){return this.rightBack;}
}

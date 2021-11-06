import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Run the world");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene theScene = new GameScene(pane, 600, 400, true); //La partie qui nous intéresse. Sinon 1600 400 peret d'avoir les deux backGround

        pane.getChildren().add(theScene.getRightBack().getImageView()); // affichage du background gauche
        pane.getChildren().add(theScene.getLeftBack().getImageView()); // " " droite
        pane.getChildren().add(theScene.getHero().getSpriteSheet());// " " Hero
        pane.getChildren().add(theScene.getFoe().getSpriteSheet());// " " Foe


        primaryStage.setScene(theScene); //initialiser la scène
        primaryStage.show(); // show

        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() { //Code permettant de récupérer l'information d'un appuie de touche
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.SPACE) { // Si appuie de la touche SPACE
                    Hero.jumpOk=1; //Permet de sauter
                }
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}

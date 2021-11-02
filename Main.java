import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
        
        primaryStage.setScene(theScene); //initialiser la scène
        primaryStage.show(); // show
    }

    public static void main(String[] args) {
        launch(args);
    }
}

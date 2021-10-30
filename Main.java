import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene theScene = new GameScene(pane, 1600, 400,true);

        pane.getChildren().add(theScene.getRightBack().getImageView());
        pane.getChildren().add(theScene.getLeftBack().getImageView());
        pane.getChildren().add(theScene.getHero().getSpriteSheet());



        primaryStage.setScene(theScene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
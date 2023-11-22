package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {

	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		Scene scene = new Scene(root,Color.BURLYWOOD);
		Image icon = new Image("icon.png");
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("JavaFX");
		primaryStage.setWidth(420);
		primaryStage.setHeight(420);
		primaryStage.setResizable(false);
		primaryStage.setX(50);
		primaryStage.setY(50);
		primaryStage.setFullScreen(true);
		primaryStage.setFullScreenExitHint("Press Q to Escape");
		primaryStage.setFullScreenExitKeyCombination(KeyCombination.valueOf("Q"));
		primaryStage.setX(50);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

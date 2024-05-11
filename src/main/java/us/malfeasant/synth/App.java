package us.malfeasant.synth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        KeyMapper keyMapper = new KeyMapper();
        Scene scene = new Scene(new Label("Ahoy!"));
        scene.setOnKeyPressed(keyMapper);
        scene.setOnKeyReleased(keyMapper);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
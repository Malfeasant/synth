package us.malfeasant.synth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new Button("Ahoy!")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
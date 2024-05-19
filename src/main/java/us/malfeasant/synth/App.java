package us.malfeasant.synth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private final KeyMapper keyMapper = new KeyMapper();
    private final HertzMapper hertzMapper = new HertzMapper();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Label("Ahoy!"));
        scene.setOnKeyPressed(e -> keyEvent(e));
        scene.setOnKeyReleased(e -> keyEvent(e));
        stage.setScene(scene);
        stage.show();
    }

    private void keyEvent(KeyEvent event) {
        var optNote = keyMapper.getNote(event.getCode());
        if (optNote.isEmpty()) return;  // unmapped key pressed
        int midiNote = optNote.get();
        float freq = hertzMapper.getHertz(midiNote);
        System.out.println("Key: " + event);
        System.out.println("Note: " + midiNote + "\tFrequency: " + freq);
    }

    public static void main(String[] args) {
        launch();
    }
}
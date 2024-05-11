package us.malfeasant.synth;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyMapper implements EventHandler<KeyEvent> {

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event);
    }
}

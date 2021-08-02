package GUI.Scenes;

import GUI.Constants;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {

    public MyScene(Pane layout) {
        super(layout, Constants.GAME_WINDOW_SIZE_X,
                Constants.GAME_WINDOW_SIZE_Y);
    }
}

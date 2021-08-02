package GUI.BuiltWindow;

import GUI.CustomControllers.MyLabel;
import GUI.Layouts.MyBorderPane;
import GUI.Layouts.MyHbox;
import GUI.Scenes.MyScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;

public class GameOverWindow {
    final private MyScene gameOverScene;
    public static MyLabel gameResultLabel;


    public GameOverWindow(String result) {

        MyBorderPane borderPane = new MyBorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));
        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);

        gameResultLabel = new MyLabel("GAME OVER\nYOU " + result);
        gameResultLabel.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 150));
        gameResultLabel.setTextFill(Color.DARKGOLDENROD);

        hbox.getChildren().add(gameResultLabel);

        borderPane.setCenter(hbox);


        this.gameOverScene = new MyScene(borderPane);
    }

    public MyScene getGameOverScene() {
        return gameOverScene;
    }
}

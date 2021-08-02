package GUI.BuiltWindow;

import GUI.Constants;
import GUI.Controller;
import GUI.CustomControllers.MyButton;
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

public class CityOrArmyWindow {
    private final MyScene cityOrArmyWindow;

    public CityOrArmyWindow(String city) {

        if (Controller.playFirstTime) {
            Constants.playMusic(Constants.cityMusic);
            Controller.playFirstTime = false;
        }

        MyHbox hbox = new MyHbox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setBackground(new Background(new BackgroundFill(Color.MAROON,
                CornerRadii.EMPTY, Insets.EMPTY)));

        MyButton armyButton = new MyButton("Show Army");
        armyButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        armyButton.setPadding(new Insets(50, 50, 50, 50));
        armyButton.setTextFill(Color.DARKGOLDENROD);
        armyButton.setOnAction(event -> {
            Controller.chooseCityOrArmy("Army", city);
        });

        MyButton cityButton = new MyButton("Show City");
        cityButton.setFont(Font.loadFont(new File("src/GUI/Resources/BerkshireSwash" +
                "-Regular.ttf").toURI().toString(), 50));
        cityButton.setPadding(new Insets(50, 50, 50, 50));
        cityButton.setTextFill(Color.DARKGOLDENROD);
        cityButton.setOnAction(event -> {
            Controller.chooseCityOrArmy("City", city);
        });

        hbox.getChildren().addAll(armyButton, Constants.spaceButton(), cityButton);

        this.cityOrArmyWindow = new MyScene(hbox);
    }

    public MyScene getCityOrArmyWindow() {
        return cityOrArmyWindow;
    }
}
